package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public String loginForm(){
		return "user/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(@ModelAttribute UserVo userVo,HttpSession session) {
	
		UserVo authUser = userService.getUser(userVo);
//		System.out.println(authUser.toString());
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		}else {
			return "redirect:/user/loginForm?result=fail";
		}
		
	}

	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		System.out.println("joinform");
		return "user/joinForm";
	}
	
	@RequestMapping(value="/joinSuccess",method=RequestMethod.POST)
	public String joinSuccess(@ModelAttribute UserVo userVo)
	{
		
		userService.join(userVo);
		
		return "user/joinSuccess";
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck", method=RequestMethod.POST)
	public String exists(@RequestParam("id") String id){
		System.out.println("id-controller");
		return userService.exists(id);
	}
	
	
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	} 
	
	
}
