package com.anaplan.modelsanitization.cli;

import com.anaplan.modelsanitization.engine.DefaultSanitisationEngine;
import com.anaplan.modelsanitization.engine.SanitizationEngine;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@SpringBootApplication
public class ModelSanitizationCliApplication implements ApplicationRunner {

    @Option(names = {"-u", "--unsanitize"}, description = "Unsanitize input")
    private boolean _sanitize;
    @Option(names = {"-s", "--sanitize"}, description = "Sanitize input")
    private boolean _unsanitize;
    @Parameters(description = "FILES", arity="1..*")
    private String[] _values;

    public static void main (String[] args) {
        SpringApplication app = new SpringApplication (ModelSanitizationCliApplication.class);
        app.setBannerMode (Banner.Mode.OFF);
        app.run (args);
    }

    @Override
    public void run (final ApplicationArguments applicationArguments) {
        SanitizationEngine sanitizationEngine = new DefaultSanitisationEngine ();
        System.out.println (sanitizationEngine.sanitize (applicationArguments.getNonOptionArgs ().get(0)));
    }

}
