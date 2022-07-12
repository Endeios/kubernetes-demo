package com.example.initcontainer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBLister {
    private final JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(DBLister.class);

    @Autowired
    public DBLister(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        logger.info("JDBC template! "+jdbcTemplate);
        var results = jdbcTemplate.query("select * FROM article", (rs, rowNum) -> {
            int id = rs.getInt(1);
            String barcode = rs.getString(3);
            String description = rs.getString(2);
            return new Article(id, barcode, description);
        });

        for(Article article:results){
            logger.info(String.valueOf(article));
        }
    }
}
