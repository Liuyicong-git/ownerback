package com.example.springbootmybatisgeneratortest.service.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootmybatisgeneratortest.mapper.MenuMapper;
import com.example.springbootmybatisgeneratortest.pojo.Menu;
import com.example.springbootmybatisgeneratortest.pojo.MenuExample;
import com.example.springbootmybatisgeneratortest.pojo.Result;
import com.example.springbootmybatisgeneratortest.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;


	@Override
	public List<Menu> getAll() {
		MenuExample example = new MenuExample();
		example.createCriteria().andIdIsNotNull();
		return menuMapper.selectByExample(example);
	}
	
	@Override
	public Integer add(Menu menu) {
		int num = menuMapper.insertSelective(menu);
		return num;
	}

	public Integer delete(Integer id) {
		int num = menuMapper.deleteByPrimaryKey(id);
		return num;
	}


	@Override
	public Integer update(Menu menu) {
		int num = menuMapper.updateByPrimaryKeySelective(menu);
		return num;
	}

	@Override
	public Integer delete(String[] idArr) {
		List<Integer> ids = new ArrayList<Integer>();
		for (String str : idArr) {
			ids.add( Integer.parseInt(str));
		}
		MenuExample example = new MenuExample();
		example.createCriteria().andIdIn(ids);
		int num = menuMapper.deleteByExample(example);
		return num;
	}

	
	
}
