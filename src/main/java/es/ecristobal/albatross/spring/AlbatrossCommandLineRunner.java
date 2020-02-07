package es.ecristobal.albatross.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class AlbatrossCommandLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbatrossCommandLineRunner.class);

    /*
     * (non-Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(final String... args) throws Exception {
        LOGGER.info("Starting migration...");
        // TODO Auto-generated method stub
        LOGGER.info("Migration completed!");
    }
}
