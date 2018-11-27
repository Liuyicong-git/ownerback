package com.example.springbootmybatisgeneratortest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	ArticleService articleService;
	
	@GetMapping
	@RequestMapping("/all")
	public Result getAllArticles(){
		return new Result("success" , StatusMap.CONTROLLER_BACK_SUCSSES , articleService.getAllArticles());
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public Result getArticleById(@PathVariable Integer id){
		return new Result("success" , StatusMap.CONTROLLER_BACK_SUCSSES , articleService.getArticleById(id));
	}
	
	@PostMapping
	@RequestMapping("/add")
	public Result addArticle(@RequestBody Article article){
		return new Result("success" , StatusMap.CONTROLLER_BACK_SUCSSES , articleService.addArticle(article));
	}
	
	@PutMapping
	@RequestMapping("/update")
	public Result updateArticle(@RequestBody Article article){
		return new Result("success" , StatusMap.CONTROLLER_BACK_SUCSSES , articleService.updateArticle(article));
	}
	
	@DeleteMapping
	@RequestMapping("/delete")
	public Result deleteArticle(String ids){
		String[] idArr = ids.split(",");
		return new Result("success" , StatusMap.CONTROLLER_BACK_SUCSSES , articleService.deleteArticle(idArr));
	}
	
}
