package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	
	public BlogVo blog(String id){
		
		return blogDao.blog(id);
	}
	
	public BlogVo blogLogout(String id){
		return blogDao.blogLogout(id);
	}
}
