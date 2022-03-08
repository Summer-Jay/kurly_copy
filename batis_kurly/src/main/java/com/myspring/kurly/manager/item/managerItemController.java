package com.myspring.kurly.manager.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class managerItemController {
	
	/*
	 * @Autowired upload upload;
	 */
	
	@Autowired
	managerItemDAO itemDAO;
	
	@RequestMapping(value = "/showAllItem.do", method = RequestMethod.GET)
	public String showAllItem(Model model, HttpServletRequest request) {
		System.out.println("====전체리스트 보기 시작===");
		List<managerItemVO> itemlist = null;
		itemlist = itemDAO.getAllItem();
		
		request.setAttribute("itemlist", itemlist);
		
		request.setAttribute("type", new Integer(1));
		model.addAttribute("cont", "16_showAllItem.jsp");
		
		System.out.println("====전체리스트 보기 끝===");
		return "00_index";
	}
	
	@RequestMapping(value = "/showNewItem.do", method = RequestMethod.GET)
	public String showNewItem(Model model, HttpServletRequest request) {
		System.out.println("====신상품 보기 시작===");
		List<managerItemVO> itemlist = null;
		itemlist = itemDAO.getNewItem();
		
		request.setAttribute("itemlist", itemlist);
		
		request.setAttribute("type", new Integer(1));
		model.addAttribute("cont", "17_showNewItem.jsp");
		System.out.println("=== 신상품보기 끝===");
		return "00_index";
	}
	
	@RequestMapping(value = "/showBestItem.do", method = RequestMethod.GET)
	public String showBestItem(Model model, HttpServletRequest request) {
		System.out.println("====베스트 보기 시작====");
		List<managerItemVO> itemlist = null;
		itemlist = itemDAO.getBestItem();
		
		request.setAttribute("itemlist", itemlist);
		
		request.setAttribute("type", new Integer(1));
		model.addAttribute("cont", "18_showBestItem.jsp");
		System.out.println("===베스트 보기 끝===");
		return "00_index";
	}
	
	@RequestMapping(value = "/showDiscountedItem.do", method = RequestMethod.GET)
	public String showDiscountedItem(Model model, HttpServletRequest request) {
		System.out.println("-===discounted 시작===");
		List<managerItemVO> itemlist = null;
		itemlist = itemDAO.getDiscountedItem();
		
		request.setAttribute("itemlist", itemlist);
		
		request.setAttribute("type", new Integer(1));
		model.addAttribute("cont", "19_showDiscountedItem.jsp");
		System.out.println("-===discounted 끝===");
		return "00_index";
	}
	
	@RequestMapping(value = "/showOneItem.do", method = RequestMethod.GET)
	public String showOneItem(Model model, HttpServletRequest request) {
		
		System.out.println("===개별상품보기 시작===");
		int item_number = Integer.parseInt(request.getParameter("item_num"));
		
		List<managerItemVO> itemlist = null;
		itemlist = itemDAO.getOneItem(item_number);
		
		request.setAttribute("onelist", itemlist);
		
		request.setAttribute("type", new Integer(1));
		model.addAttribute("cont", "20_showOneItem.jsp");
		System.out.println("===개별상품보기 끝===");
		return "00_index";
	}
}
