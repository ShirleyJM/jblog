package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CateDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CateVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CateDao cateDao;
	
	@Transactional
    public void join(UserVo userVo){
    	BlogVo blogVo= new BlogVo(userVo.getId(),userVo.getUserName()+"의 블로그입니다.","default.jpg");
    	CateVo cateVo= new CateVo(userVo.getId());
    	
		userDao.insert(userVo);
		blogDao.insert(blogVo);
		cateDao.insert(cateVo);
		
    }
    
	public UserVo getUser(UserVo userVo) {
			return userDao.getUser(userVo);
		}	
		
	
	public String exists(String id) {
		String exist = "false";
		UserVo vo = userDao.exist(id);
		if (vo != null) {
			exist = "true";
		} else {
			exist = "false";
		}
		return exist;
	}
	
	
}
