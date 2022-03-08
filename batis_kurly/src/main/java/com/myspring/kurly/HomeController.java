package com.myspring.kurly;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
	
		System.out.println("====/시작====");
		return "redirect:/index.do";
	}
	
	@RequestMapping(value= "/index.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("===index.do 시작====");
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "00_shopMain.jsp");		
		System.out.println("===index.do 끝====");
		return "00_index";
	}
	
	
	
	
}
