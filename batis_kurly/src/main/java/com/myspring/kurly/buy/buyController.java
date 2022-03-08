package com.myspring.kurly.buy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.kurly.cart.cartDAO;
import com.myspring.kurly.cart.cartVO;
import com.myspring.kurly.manager.item.managerItemDAO;
import com.myspring.kurly.manager.item.managerItemVO;
import com.myspring.kurly.member.dao.memberDAOImpl;
import com.myspring.kurly.member.vo.memberVO;


@Controller
public class buyController {
	@Autowired
	buyDAO buyDAO;
	
	@Autowired
	cartDAO cartDAO;
	
	@Autowired
	memberDAOImpl memberDAO;
	
	@Autowired
	managerItemDAO itemDAO;
	
	@RequestMapping(value = "/order.do", method = RequestMethod.POST)
	public String order(Model model, HttpServletRequest request) {
		System.out.println("===order폼 start==");
		int total = Integer.parseInt(request.getParameter("total"));
		
		HttpSession session = request.getSession();
		String buyer =(String)session.getAttribute("id");
		List<cartVO> list = cartDAO.getCartList(buyer);
		
		List<memberVO> customer = memberDAO.getMemberInfo(buyer);
		
		request.setAttribute("orderList", list);
		request.setAttribute("customerBean", customer);
		request.setAttribute("total", total);
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "25_orderForm.jsp");
		System.out.println("===order폼 end===");
		return "00_index";
		
	}
	
	@RequestMapping(value = "/insertOrderList.do", method = RequestMethod.POST)
	public String insertOrderList(Model model, HttpServletRequest request) {
		System.out.println("===insertOrderList start==");
		
		HttpSession session = request.getSession();
		String buyer =(String)session.getAttribute("id");
		List<memberVO> customer = memberDAO.getMemberInfo(buyer);
		List<cartVO> list = cartDAO.getCartList(buyer);
		
		int total = Integer.parseInt(request.getParameter("total"));
		int payhow = Integer.parseInt(request.getParameter("howPay"));
		String pay="";
		if(payhow==1){
			pay="계좌이체";
		}else if(payhow==2){
			pay="신용카드";
		}
		
		
		for(int i=0;i<list.size();i++) {
			buyVO vo = new buyVO();
			vo.setCustomer_id(buyer);
			vo.setCustomer_name(customer.get(0).getName());
			vo.setCart_number(list.get(i).getCart_number());
			vo.setItem_name(list.get(i).getItem_name());
			vo.setBuy_price(list.get(i).getBuy_price());
			vo.setBuy_count(list.get(i).getBuy_count());
			vo.setItem_image(list.get(i).getItem_image());
			vo.setHowpay(pay);
			vo.setAddress(customer.get(0).getAddress());
			
			buyDAO.insertOrderList(vo);
			String item_name = list.get(i).getItem_name();
			
			int nowsold = itemDAO.getSold(item_name);
			int nowstock = itemDAO.getStock(item_name);
			
			managerItemVO itemvo = itemDAO.getOneItembyName(list.get(i).getItem_name());
			itemvo.setSold(nowsold+list.get(i).getBuy_count());
			itemvo.setItem_stock(nowstock-list.get(i).getBuy_count());
			
			itemDAO.updateSold(itemvo, list.get(i).getItem_name());
			
			
			
			
		}
		cartDAO.deleteCartList(buyer);
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "26_insertOrderList.jsp");
		
		System.out.println("===insertOrderList end===");
		return "00_index";
		
	}
	
	@RequestMapping(value = "/checkMyOrderList.do", method = RequestMethod.GET)
	public String checkMyOrderList(Model model, HttpServletRequest request) {
		System.out.println("===checkMyOrderList start==");
		
		HttpSession session = request.getSession();
		String customer_id = (String) session.getAttribute("id");
		
		List<buyVO> list = buyDAO.getBuyList(customer_id);
		System.out.println("list size=" + list.size());
		
		model.addAttribute("cnt", list.size());
		model.addAttribute("buylist", list);
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "23_checkMyOrderList.jsp");
		
		System.out.println("===checkMyOrderList end===");
		return "00_index";
		
	}
}
