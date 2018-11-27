package com.example.springbootmybatisgeneratortest.service;

import java.util.List;

import com.example.springbootmybatisgeneratortest.pojo.Article;

public interface ArticleService {

	List<Article> getAllArticles();

	Integer addArticle(Article article);
	
	Integer updateArticle(Article article);
	
	Integer deleteArticle(String[] ids);

	Article getArticleById(Integer id);
}
