package com.example.simplewebapp.integration;

import com.example.simplewebapp.SimpleWebAppApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@Profile("integration-tests") // don't let it be discovered during startup of the service under test, otherwise it will reload continuously
@PropertySource("file:${docker.ports.file}")
public class ITConfiguration {

    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "close")
    ConfigurableApplicationContext service() {
        String prop = environment.getRequiredProperty("docker.ports.file");
        System.out.println("Docker file with ports : " + prop);
        return SimpleWebAppApplication.run(
                "--spring.config.additional-location="
                + "file:" + environment.getRequiredProperty("docker.ports.file")

        );
    }
}
