package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Controller
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String blogMain(@PathVariable("id") String id, Model model){	
		
		BlogVo blogVo = blogService.blog(id);
		//블로그가 없으면 메인페이지로 가기
		if(blogVo==null){
			return "redirect:/"; 
		} else {
		//Model에 담기
		model.addAttribute("blogVo",blogVo);
		return "/blog/blog-main";
		}	
	}
	
	@RequestMapping(value="/{id}/admin/basic",method=RequestMethod.GET)
	public String blogAdminBasic(@PathVariable("id") String id, Model model){
		BlogVo blogVo =blogService.blog(id);
		model.addAttribute("blogVo",blogVo);
		return "/blog/admin/blog-admin-basic";
	}
	
	@RequestMapping(value="/{id}/admin/cate",method=RequestMethod.GET)
	public String blogAdminCate(@PathVariable String id, Model model){
		BlogVo blogVo = blogService.blog(id);
		model.addAttribute("blogVo",blogVo);
		return "/blog/admin/blog-admin-cate";
	}
	
	@RequestMapping(value="/{id/admin/write}",method=RequestMethod.GET)
	public String blogAdminWrite(@PathVariable String id, Model model){
		BlogVo blogVo =blogService.blog(id);
		model.addAttribute("blogVo",blogVo);
		return "/blog/admin/blog-admin-write";
	}
	
	@RequestMapping(value="/logoutBlogMain",method=RequestMethod.GET)
	public String logoutBlogMain(Model model,HttpSession session){
		
		//사진을 가져온다
		//블로그타이틀을 가져온다
		
		UserVo id =(UserVo)session.getAttribute("authUser");
		BlogVo blogVo = blogService.blogLogout(id.getId());
		model.addAttribute("blogVo",blogVo);
		
		session.removeAttribute("authUser");
		session.invalidate();
		System.out.println("세션삭제");

		return "/blog/blog-main";
	}
	
/*	@RequestMapping(value="/blogAdminBasicModify",method=RequestMethod.GET)
	public String BlogAdminBasicModify(){
		
		
	}*/
	
	
	
}
