package es.ecristobal.albatross.migration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MigrationScriptBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(MigrationScriptBuilder.class);

    private final List<MigrationVersion> migrationVersions;

    public MigrationScriptBuilder() {
        this.migrationVersions = new ArrayList<>();
    }

    public MigrationScriptBuilder addMigrationVersionWithRollback(final MigrationStep migrationStep,
            final RollbackMigrationStep rollbackMigrationStep) {
        this.migrationVersions.add(new MigrationVersion(migrationStep, rollbackMigrationStep));
        return this;
    }

    public MigrationScriptBuilder addMigrationVersion(final MigrationStep migrationStep) {
        this.migrationVersions.add(new MigrationVersion(migrationStep));
        return this;
    }

    public void runMigration(final List<String> migrationStepsRun) {
        LOGGER.info("Migration consists of the following steps: ", this.migrationVersions);
        for (final MigrationVersion migrationVersion : this.migrationVersions) {
            final String migrationStepName = migrationVersion.getMigrationStep().getClass().getName();
            if (!migrationStepsRun.contains(migrationStepName)) {
                LOGGER.debug("Migration step to be executed: {}", migrationStepName);
                // TODO Run migration step
                migrationVersion.getMigrationStep();
                final Optional<RollbackMigrationStep> optional = migrationVersion.getRollbackMigrationStep();
                if (optional.isPresent()) {
                    migrationVersion.getRollbackMigrationStep();
                }
                // TODO Run rollback migration step
            } else {
                LOGGER.debug("Migration step already executed: {}", migrationStepName);
            }
        }
    }

    private class MigrationVersion {

        private final MigrationStep migrationStep;

        private final Optional<RollbackMigrationStep> rollbackMigrationStep;

        public MigrationVersion(final MigrationStep migrationStep) {
            this.migrationStep = migrationStep;
            this.rollbackMigrationStep = Optional.empty();
        }

        public MigrationVersion(final MigrationStep migrationStep, final RollbackMigrationStep rollbackMigrationStep) {
            this.migrationStep = migrationStep;
            this.rollbackMigrationStep = Optional.of(rollbackMigrationStep);
        }

        public MigrationStep getMigrationStep() {
            return this.migrationStep;
        }

        public Optional<RollbackMigrationStep> getRollbackMigrationStep() {
            return this.rollbackMigrationStep;
        }
    }
}
