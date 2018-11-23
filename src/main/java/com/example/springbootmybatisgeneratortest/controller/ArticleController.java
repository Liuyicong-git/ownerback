package com.example.springbootmybatisgeneratortest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmybatisgeneratortest.pojo.Article;
import com.example.springbootmybatisgeneratortest.pojo.Result;
import com.example.springbootmybatisgeneratortest.pojo.StatusMap;
import com.example.springbootmybatisgeneratortest.service.ArticleService;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

	@Autowired
	ArticleService articleServicel;
	
	@GetMapping
	@RequestMapping("/all")
	public Result getAllArticles(){
		return new Result("success" , StatusMap.CONTROLLER_BACK_SUCSSES , articleServicel.getAllArticles());
	}
	
	@PostMapping
	@RequestMapping("/add")
	public Result addArticle(Article article){
		return new Result("success" , StatusMap.CONTROLLER_BACK_SUCSSES , articleServicel.addArticle(article));
	}
	
	@PutMapping
	@RequestMapping("/update")
	public Result updateArticle(Article article){
		return new Result("success" , StatusMap.CONTROLLER_BACK_SUCSSES , articleServicel.updateArticle(article));
	}
	
	@DeleteMapping
	@RequestMapping("/delete")
	public Result deleteArticle(String ids){
		String[] idArr = ids.split(",");
		return new Result("success" , StatusMap.CONTROLLER_BACK_SUCSSES , articleServicel.deleteArticle(idArr));
	}
	
}
