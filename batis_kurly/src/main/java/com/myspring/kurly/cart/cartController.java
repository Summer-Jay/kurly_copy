package com.myspring.kurly.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class cartController {
	@Autowired
	cartDAO cartDAO;
	
	@RequestMapping(value = "/insertCart.do", method = RequestMethod.POST)
	public String insertCart(Model model, HttpServletRequest request) {
		System.out.println("===insertcart start==");
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		HttpSession session = request.getSession();
		String buyer =(String)session.getAttribute("id");
		
		int cart_number = cartDAO.getMaxCartNumber();
		String item_name = request.getParameter("item_name");
		int buy_price = Integer.parseInt(request.getParameter("buy_price"));
		int buy_count = Integer.parseInt(request.getParameter("buycnt"));
		String item_image = request.getParameter("item_image");
	
		if(buyer==null) {
			System.out.println("buyer는 null이다");
		}
		if(buyer!=null) {
			cartVO vo = new cartVO();
			vo.setCart_number(cart_number+1);
			vo.setBuyer(buyer);
			vo.setItem_name(item_name);
			vo.setBuy_price(buy_price);
			vo.setBuy_count(buy_count);
			vo.setItem_image(item_image);
			
			cartDAO.insertCart(vo);
		
		}
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "24_insertCart.jsp");
		System.out.println("===insertcart end===");
		return "00_index";
	}
	
	
	@RequestMapping(value = "/cartInfo.do", method = RequestMethod.GET)
	public String cartInfo(Model model, HttpServletRequest request) {
		System.out.println("===cartInfo start==");
		HttpSession session = request.getSession();
		String buyer =(String)session.getAttribute("id");
		System.out.println("buyer=" + buyer);
		
		
		List<cartVO> list = null;
		
		int cnt=cartDAO.getCnt(buyer);
		System.out.println("cnt = " + cnt);
		request.setAttribute("cnt", cnt);
		
		if(cnt>0) {
			list = cartDAO.getCartList(buyer);
			model.addAttribute("mycartlist", list);
			//request.setAttribute("mycartlist", list);
			System.out.println("list갯수확인 = " + list.size());
		}
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "21_cartInfo.jsp");
		System.out.println("===cartInfo end===");
		return "00_index";
	}
	
	@RequestMapping(value = "/deleteCart.do", method = RequestMethod.POST)
	public String deleteCart(Model model, HttpServletRequest request) {
		System.out.println("===deleteCart start==");
		
		int cart_number = Integer.parseInt(request.getParameter("cart_number"));
		System.out.println("cart_number = " + cart_number);
		
		cartDAO.deleteCart(cart_number);
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "22_deleteCart.jsp");
		System.out.println("===deleteCart end===");
		return "00_index";
	}
	
}
