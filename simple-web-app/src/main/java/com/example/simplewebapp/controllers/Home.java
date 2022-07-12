package com.example.simplewebapp.controllers;

import com.example.simplewebapp.dtos.Article;
import com.example.simplewebapp.repo.ArticleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class Home {
    public static final String KUBERNETES_SERVICE_HOST = "KUBERNETES_SERVICE_HOST";
    public static final String HOSTNAME = "HOSTNAME";
    private static Logger logger = LoggerFactory.getLogger(Home.class);
    private ArticleRepo articleRepo;

    @Autowired
    public Home(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
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
        Iterable<Article> articles = articleRepo.findAll();
        modelAndView.addObject("pod",pod);
        modelAndView.addObject("articles",articles);
        logger.debug(String.valueOf(env));
        return modelAndView;
    }
}
