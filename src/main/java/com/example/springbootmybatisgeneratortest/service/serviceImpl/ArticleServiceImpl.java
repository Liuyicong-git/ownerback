package com.example.springbootmybatisgeneratortest.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmybatisgeneratortest.mapper.ArticleMapper;
import com.example.springbootmybatisgeneratortest.pojo.Article;
import com.example.springbootmybatisgeneratortest.pojo.ArticleExample;
import com.example.springbootmybatisgeneratortest.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleMapper articleMapper;
	
	@Override
	public List<Article> getAllArticles() {
		ArticleExample example = new ArticleExample();
		example.createCriteria().andIdIsNotNull();
		return articleMapper.selectByExample(example);
	}

	@Override
	public Integer addArticle(Article article) {
		int num = articleMapper.insertSelective(article);
		return num;
	}

	@Override
	public Integer updateArticle(Article article) {
		int num = articleMapper.updateByPrimaryKeySelective(article);
		return num;
	}

	@Override
	public Integer deleteArticle(String[] idArr) {
		List<Integer> ids = new ArrayList<Integer>();
		for (String str : idArr) {
			ids.add( Integer.parseInt(str));
		}
		ArticleExample example = new ArticleExample();
		example.createCriteria().andIdIn(ids);
		int num = articleMapper.deleteByExample(example);
		return num;
	}

	
}
