package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javaex.vo.CateVo;



@Repository
public class CateDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insert(CateVo cateVo){
		return sqlSession.insert("category.insert",cateVo);
	}
}
