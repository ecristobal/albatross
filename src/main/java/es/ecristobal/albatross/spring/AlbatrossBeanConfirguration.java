package es.ecristobal.albatross.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.ecristobal.albatross.reporting.DefaultReportingService;
import es.ecristobal.albatross.reporting.ReportingService;

@Configuration
public class AlbatrossBeanConfirguration {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new AlbatrossCommandLineRunner();
    }

    @ConditionalOnMissingBean
    @Bean
    public ReportingService reportingService() {
        return new DefaultReportingService();
    }
}
