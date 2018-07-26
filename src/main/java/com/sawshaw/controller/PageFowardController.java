package com.sawshaw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * @author mercy
 *页面跳转功能
 */
@Controller
@RequestMapping("/me")
public class PageFowardController {
	@RequestMapping("/greeting")
	@ResponseBody
	public String greeting(){
		JSONObject js=new JSONObject();
		js.put("id", "myId");
		js.put("content", "mycontent");
		return js.toJSONString();
	}
	@RequestMapping("/getHelloUrl")
	public ModelAndView handleRequest( HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("forward:/WEB-INF/views/hello.jsp");
		return mav;
	}
	@RequestMapping("/getHelloUrl0")
	public String handleRequest0( HttpServletRequest request,HttpServletResponse response){
		return "hello";
	}
	@RequestMapping("/getHelloUrl1")
	public void handleRequest1( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("hello.jsp").forward(request, response);
	}
	
	/**
	 * @param request
	 * 这个方法是重定向webapp下的hello.html
	 * @param response
	 * @return
	 */
	@RequestMapping("/getHelloUrl2")
	public ModelAndView handleRequest2( HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("redirect:/hello.html");
	    return mv;
	}
	/**
	 * @param request
	 * 这个方法是重定向webapp下的hello.html
	 * @param response
	 * @return
	 */
	@RequestMapping("/getHelloUrl3")
	public String handleRequest3( HttpServletRequest request,HttpServletResponse response){
		return "redirect:/hello.html";
	}
	
	/**
	 * @param request
	 * 这个方法是重定向webapp下的hello.html
	 * @param response
	 * @return
	 */
	@RequestMapping("/getHelloUrl4")
	public void handleRequest4( HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.sendRedirect(request.getContextPath()+"/hello.html");
	}
	@RequestMapping("/getHelloUrl5")
	public void handleRequest5( HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//失败
		//request.getRequestDispatcher("hello.jsp").forward(request, response);
		//成功
		response.sendRedirect(request.getContextPath()+"/hello.jsp");
	}
	@RequestMapping("/postData")
	@ResponseBody
	public String postData(HttpServletRequest request,HttpServletResponse response){
		String userName=request.getParameter("userName");
		System.out.println("userName:"+userName);
		return userName;
	}

}
