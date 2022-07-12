package com.example.simplewebapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class Home {
    public static final String KUBERNETES_SERVICE_HOST = "KUBERNETES_SERVICE_HOST";
    public static final String HOSTNAME = "HOSTNAME";
    private static Logger logger = LoggerFactory.getLogger(Home.class);

    public Home() {
        logger.info("Startup app");
    }

    @GetMapping( "/index.html")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        Map<String, String> env = System.getenv();
        String pod="";
        if(env.containsKey(KUBERNETES_SERVICE_HOST)){
            pod = env.get(HOSTNAME);
            logger.info("I am under kubernetes");
        } else {
            pod = "Boring phisical machine";
            logger.info("I am in a normal machine");
        }
        modelAndView.addObject("pod",pod);
        logger.debug(String.valueOf(env));
        return modelAndView;
    }
}
