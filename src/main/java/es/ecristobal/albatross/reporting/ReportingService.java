package es.ecristobal.albatross.reporting;

public interface ReportingService {

    void reportSuccess(final ReportingData reportingData);

    void reportFailure(final ReportingData reportingData);

    void reportRollback(final ReportingData reportingData);
}
