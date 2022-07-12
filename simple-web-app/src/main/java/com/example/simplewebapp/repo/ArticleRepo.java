package com.example.simplewebapp.repo;

import com.example.simplewebapp.dtos.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepo extends CrudRepository<Article,Integer> {
}
