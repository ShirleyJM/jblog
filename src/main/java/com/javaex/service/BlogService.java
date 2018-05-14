package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	public void blogAdminBasicModify(String id,MultipartFile file, String blogTitle){
	
		
		if(file.isEmpty()){
			Map<String,Object> map = new HashMap<String,Object>(); 
			
			map.put("id",id);
			map.put("blogTitle",blogTitle);
			
			blogDao.blogAdminBasicModify(map);
			
		
			
		} else{
		
		
		Map<String,Object> map = new HashMap<String,Object>(); 
		
		map.put("id",id);
		map.put("blogTitle",blogTitle);
		
		//확장자
				String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				System.out.println("exName: " + exName);
						
				//저장파일명
				String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
				map.put("saveName", saveName);
			
		//다오 연결 DB저장**
		
		blogDao.blogAdminBasicModify(map);
		
		//파일 서버 복사
				String saveDir="D:\\javaStudy\\pics";
				
				try {
					byte[] fileData = file.getBytes();
					OutputStream out = new FileOutputStream( saveDir + "/" + saveName);
					BufferedOutputStream bout = new BufferedOutputStream(out);		
					
					bout.write(fileData);
					
					if(bout != null) {
						bout.close();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
	}
	
}
