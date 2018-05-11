package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insert(UserVo userVo){
		return sqlSession.insert("user.insert",userVo);
	}
	
	public UserVo getUser(UserVo userVo){
		return sqlSession.selectOne("user.selectUserById", userVo);
	}
	
	public UserVo exist(String id) {
		return sqlSession.selectOne("user.exist", id);
	}
	
}
