package com.example.simplewebapp;

import com.example.simplewebapp.integration.ITConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;

@SpringBootTest()
@ActiveProfiles("integration-tests")
@ContextHierarchy(@ContextConfiguration(classes = {ITConfiguration.class}))
class SimpleWebAppApplicationIT {

    @Test
    void contextLoads() {
    }

}
