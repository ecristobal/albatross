package es.ecristobal.albatross.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultReportingService implements ReportingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultReportingService.class);

    @Override
    public void reportSuccess(final ReportingData reportingData) {
        LOGGER.info("Reporting successful execution with data {}", reportingData);
        // TODO Auto-generated method stub
    }

    @Override
    public void reportFailure(final ReportingData reportingData) {
        LOGGER.warn("Reporting failing execution with data {}", reportingData);
        // TODO Auto-generated method stub
    }

    @Override
    public void reportRollback(final ReportingData reportingData) {
        LOGGER.info("Reporting rolling back with data {}", reportingData);
        // TODO Auto-generated method stub
    }
}
