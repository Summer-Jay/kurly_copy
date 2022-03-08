package com.myspring.kurly.member.controller;

import java.awt.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kurly.manager.item.managerItemVO;
import com.myspring.kurly.member.dao.memberDAO;
import com.myspring.kurly.member.service.memberService;
import com.myspring.kurly.member.vo.memberVO;

@Controller("memberController")
public class memberControllerImpl implements memberController {
	
	@Autowired
	private memberService memberService;
	
	@Autowired
	memberDAO memberDAO;
	
	@RequestMapping(value= "/join.do", method = RequestMethod.GET)
	public String join(Model model) throws Exception {
		System.out.println("===join.do 시작====");
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "27_joinForm.jsp");		
		System.out.println("===join.do 끝====");
		return "00_index";
	}
	
	@RequestMapping(value= "/joinPro.do", method = RequestMethod.POST)
	public String joinPro(memberVO member, Model model, HttpServletRequest request) throws Exception {
		System.out.println("===joinPro.do 시작====");
		int result = 0;
		result = memberService.addMember(member);
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "28_joinPro.jsp");
		
		System.out.println("===joinPro.do 끝====");
		return "00_index";
	}
	
	
	@RequestMapping(value= "/login.do", method = RequestMethod.GET)
	public String login(Model model) throws Exception {
		System.out.println("===login.do 시작====");
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "13_login.jsp");		
		System.out.println("===login.do 끝====");
		return "00_index";
	}
	
	@RequestMapping(value= "/loginPro.do", method = RequestMethod.POST)
	public String loginPro(memberVO member, Model model, HttpServletRequest request) throws Exception {
		System.out.println("===loginPro.do 시작====");
		memberVO memberVO ;
		memberVO = memberService.login(member);
		int check=-1;
		if (memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO);
			session.setAttribute("id", memberVO.getId());
			session.setAttribute("isLogOn", true);
			
			check=1;
			model.addAttribute("check",check);
			model.addAttribute("type", new Integer(1));
			model.addAttribute("cont", "14_loginPro.jsp");		
		} else {
			model.addAttribute("type", new Integer(1));
			model.addAttribute("cont", "14_loginPro.jsp");		
		}
		System.out.println("===loginPro.do 끝====");
		return "00_index";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) throws Exception {
		System.out.println("===logout.do 시작====");
		session.invalidate();
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "00_shopMain.jsp");	
		System.out.println("===logout.do 끝====");
		return "00_index";
	}
	
	

}
