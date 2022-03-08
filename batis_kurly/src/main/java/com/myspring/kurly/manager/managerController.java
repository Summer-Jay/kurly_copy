package com.myspring.kurly.manager;

import java.awt.image.ImageProducer;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myspring.kurly.buy.buyDAO;
import com.myspring.kurly.buy.buyVO;
import com.myspring.kurly.manager.item.managerItemDAO;
import com.myspring.kurly.manager.item.managerItemVO;
import com.myspring.kurly.member.dao.memberDAOImpl;

@Controller
public class managerController {
	@Autowired
	managerDAO managerDAO;
	
	@Autowired
	buyDAO buyDAO;
	
	@Autowired
	memberDAOImpl memberDAO;
	
	@Autowired
	managerItemDAO itemDAO;
	
	@Autowired
	upload upload;
	
	@RequestMapping(value= "/managerMain.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("===managerMain.do 시작====");
		
		model.addAttribute("membercnt", memberDAO.getmembercnt());
		model.addAttribute("itemcnt",itemDAO.getitemcnt());
		model.addAttribute("buycnt", buyDAO.getbuycnt());
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "01_managerMain.jsp");		
		System.out.println("===managerMain.do 끝====");
		return "00_index";
	}
	
	
	@RequestMapping(value = "/managerLoginPro.do", method = RequestMethod.POST)
	public String managerLoginPro(Model model , HttpServletRequest request) {
		System.out.println("===managerLoginPro start===");
        String id = request.getParameter("id");
	    String pw  = request.getParameter("pw");
	    
	    String dbpw = managerDAO.loginById(id);
	    int check=-1;
	    if(dbpw.equals(pw)) {
	    	check=1;
	    	System.out.println("check=" + check);
	    	request.setAttribute("check", check);
	    	request.setAttribute("id", id);
	    }

		model.addAttribute("cont", "03_managerLoginPro.jsp");		
		System.out.println("===managerLoginPro end===");
		return "00_index";
	}
	
	@RequestMapping(value = "/managerLogout.do", method = RequestMethod.POST)
	public String managerLogout(Model model , HttpServletRequest request, HttpSession session) {
		System.out.println("===managerLogout start===");
		session.invalidate();
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "01_managerMain.jsp");	
		System.out.println("===managerLogout end===");
		return "00_index";
	}
	
	@RequestMapping(value = "/checkOrderList.do", method = RequestMethod.GET)
	public String checkOrderList(Model model , HttpServletRequest request, HttpSession session) {
		System.out.println("===checkOrderList start===");
		
		List<buyVO> list = buyDAO.getAllBuyList();
		
		model.addAttribute("orderlist", list);
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "10_checkOrderList.jsp");	
		System.out.println("===checkOrderList end===");
		return "00_index";
	}
	
	
	@RequestMapping(value = "/addNewItem.do", method = RequestMethod.GET)
	public String addNewItem(Model model , HttpServletRequest request, HttpSession session) {
		System.out.println("===addNewItem start===");
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "05_addNewItem.jsp");	
		System.out.println("===addNewItem end===");
		return "00_index";
	}
	
	@RequestMapping(value = "/addNewItemPro.do", method = RequestMethod.POST)
	public String addNewItemPro(Model model , HttpServletRequest request, HttpSession session, MultipartHttpServletRequest mRequest) {
		System.out.println("===addNewItemPro start===");
		try {
			mRequest.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String loadName = upload.fileUpload(mRequest);

		if (loadName.equals("")) {
			System.out.println("파일 업로드 실패!!");
		} else {
			System.out.println("파일 업로드 성공!!");
		}

		MultipartHttpServletRequest imageUp = mRequest;
		int item_number = itemDAO.getitemcnt();
		String item_name = imageUp.getParameter("name");
		String item_category = imageUp.getParameter("category");
		int item_price = Integer.parseInt(imageUp.getParameter("price"));
		int item_stock = Integer.parseInt(imageUp.getParameter("stock"));
		String item_image = imageUp.getParameter("image");
		String item_info = imageUp.getParameter("info");
		int discount_rate = Integer.parseInt(imageUp.getParameter("discountRate"));
		
		managerItemVO itemvo = new managerItemVO();
		itemvo.setItem_number(item_number+1);
		itemvo.setItem_name(item_name);
		itemvo.setItem_category(item_category);
		itemvo.setItem_price(item_price);
		itemvo.setItem_stock(item_stock);
		itemvo.setItem_image(item_image);
		itemvo.setItem_info(item_info);
		itemvo.setDiscount_rate(discount_rate);
		
		itemDAO.addNewItem(itemvo);
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "06_addNewItemPro.jsp");	
		System.out.println("===addNewItemPro end===");
		return "00_index";
	}
	
	
	@RequestMapping(value = "/itemListForManager.do", method = RequestMethod.GET)
	public String itemListForManager(Model model , HttpServletRequest request, HttpSession session) {
		System.out.println("===itemListForManager start===");
		
		
		
		
		List<managerItemVO> list = itemDAO.getAllItem();
		System.out.println("list 사이즈 = " + list.size());
		model.addAttribute("registeredItemList",list);
		model.addAttribute("cnt", list.size());
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "12_itemListForManager.jsp");	
		System.out.println("===itemListForManager end===");
		return "00_index";
	}
	
	@RequestMapping(value = "/updateItem.do", method = RequestMethod.POST)
	public String updateItem(Model model , HttpServletRequest request, HttpSession session) {
		System.out.println("===updateItem start===");
		
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		List<managerItemVO> bean = itemDAO.getOneItem(item_number);
		model.addAttribute("beanforupdate", bean);	
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "07_updateItem.jsp");	
		System.out.println("===updateItem end===");
		return "00_index";
	}
	
	@RequestMapping(value = "/updateItemPro.do", method = RequestMethod.POST)
	public String updateItemPro(Model model , HttpServletRequest request, HttpSession session, MultipartHttpServletRequest mRequest) {
		System.out.println("===updateItemPro start===");
		
		try {
			mRequest.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		String loadName = upload.fileUpload(mRequest);

		if (loadName.equals("")) {
			System.out.println("파일 업로드 실패!!");
		} else {
			System.out.println("파일 업로드 성공!!");
		}

		MultipartHttpServletRequest imageUp = mRequest;
		int item_number = Integer.parseInt(imageUp.getParameter("item_number"));
		
		String item_name = imageUp.getParameter("item_name");
		String item_category = imageUp.getParameter("item_category");
		String item_price = imageUp.getParameter("item_price");
		String item_stock = imageUp.getParameter("item_stock");
		String item_image = imageUp.getParameter("item_image");
		String item_info = imageUp.getParameter("item_info");
		String discount_rate = imageUp.getParameter("discount_rate");
		
		managerItemVO itemvo = new managerItemVO();
		itemvo.setItem_name(item_name);
		itemvo.setItem_category(item_category);
		itemvo.setItem_price(Integer.parseInt(item_price));
		itemvo.setItem_stock(Integer.parseInt(item_stock));
		itemvo.setItem_image(item_image);
		itemvo.setItem_info(item_info);
		itemvo.setDiscount_rate(Integer.parseInt(discount_rate));
		
		
		itemDAO.updateItem(itemvo, item_number);
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "08_updateItemPro.jsp");	
		System.out.println("===updateItemPro end===");
		return "00_index";
	}
	
	
	@RequestMapping(value = "/deleteItemPro.do", method = RequestMethod.POST)
	public String deleteItemPro(Model model , HttpServletRequest request, HttpSession session) {
		System.out.println("===deleteItemPro start===");
		System.out.println("111111");
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		System.out.println("item_number = " + item_number);
		itemDAO.deleteItem(item_number);
		System.out.println("22222");
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "09_deleteItemPro.jsp");	
		System.out.println("===deleteItemPro end===");
		return "00_index";
	}
	
	
}
