package com.example.springbootmybatisgeneratortest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmybatisgeneratortest.pojo.Menu;
import com.example.springbootmybatisgeneratortest.pojo.Result;
import com.example.springbootmybatisgeneratortest.pojo.StatusMap;
import com.example.springbootmybatisgeneratortest.service.MenuService;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	
	@GetMapping("/all")
	@ResponseBody
	public Result getAll(){
		return new Result("sucsses" , StatusMap.CONTROLLER_BACK_SUCSSES, menuService.getAll());
	}
	
	@PostMapping("/add")
	@ResponseBody
	public Result add(@RequestBody Menu menu){
		return new Result("sucsses",StatusMap.CONTROLLER_BACK_SUCSSES, menuService.add(menu));
	}
	
	@PutMapping("/update")
	@ResponseBody
	public Result update(@RequestBody Menu menu){
		return new Result("sucsses",StatusMap.CONTROLLER_BACK_SUCSSES, menuService.update(menu));
	}
	
	@DeleteMapping("/delete/{ids}")
	public Result deleteById(@PathVariable String ids){
		String[] idArr = ids.split(",");
		return new Result("sucsses",StatusMap.CONTROLLER_BACK_SUCSSES, menuService.delete(idArr));
	}
}
