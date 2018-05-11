package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insert(BlogVo blogVo){
		
		return sqlSession.insert("blog.insert",blogVo);
	}
	
	public BlogVo blog(String id){
		return sqlSession.selectOne("blog.select",id);
	}
	
	public BlogVo blogLogout(String id){
		return sqlSession.selectOne("blog.select",id);
	}
}
