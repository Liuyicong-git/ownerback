package com.example.springbootmybatisgeneratortest.service;

import java.util.List;

import com.example.springbootmybatisgeneratortest.pojo.Menu;

public interface MenuService {
	
	List<Menu> getAll();
	
	Integer add(Menu menu);

	Integer delete(String[] idArr);
	
	Integer update(Menu menu);

	
}
