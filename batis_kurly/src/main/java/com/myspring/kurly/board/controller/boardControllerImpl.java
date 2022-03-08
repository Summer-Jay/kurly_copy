package com.myspring.kurly.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.kurly.board.dao.boardDAOImpl;
import com.myspring.kurly.board.vo.boardVO;

@Controller
public class boardControllerImpl {
	@Autowired
	boardDAOImpl boardDAO;
	
	@RequestMapping(value= "/adminShowBoardList.do", method = RequestMethod.GET)
	public String adminShowBoardList(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("===adminShowBoardList.do 시작====");
		
		int pageSize = 10;
		String pageNumber = request.getParameter("pageNum");
	
		if(pageNumber == null) {
			pageNumber = "1";
		}
		int count = 0;
		int number = 0;	
		
		int currentPage = Integer.parseInt(pageNumber);	
				
		count = boardDAO.getBoardCount();
				
		int startRow = (currentPage - 1) * pageSize;
		int endRow = currentPage * pageSize;
		List<boardVO> boardList = boardDAO.getBoardListCurrentPage(startRow, pageSize);
		number = count - (currentPage - 1) * pageSize;
		
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);	
		int startPage = 1;
		if(currentPage % pageSize != 0){
			startPage = (int)(currentPage / pageSize) * pageSize + 1;
		}else{
			startPage = ((int)(currentPage / pageSize )- 1) * pageSize + 1;
		}
		int endPage = startPage + pageSize - 1;	
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("boardlist", boardList);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "40_adminShowBoardList.jsp");		
		System.out.println("===adminShowBoardList.do 끝====");
		return "00_index";
	}
	
	@RequestMapping(value= "/showBoardListForCustomer.do", method = RequestMethod.GET)
	public String showBoardListForCustomer(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("===showBoardListForCustomer.do 시작====");
		
		int pageSize = 10;
		String pageNumber = request.getParameter("pageNum");
	
		if(pageNumber == null) {
			pageNumber = "1";
		}
		int count = 0;
		int number = 0;	
		
		int currentPage = Integer.parseInt(pageNumber);	
				
		count = boardDAO.getBoardCount();
				
		int startRow = (currentPage - 1) * pageSize;
		int endRow = currentPage * pageSize;
		List<boardVO> boardList = boardDAO.getBoardListCurrentPage(startRow, pageSize);
		number = count - (currentPage - 1) * pageSize;
		
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);	
		int startPage = 1;
		if(currentPage % pageSize != 0){
			startPage = (int)(currentPage / pageSize) * pageSize + 1;
		}else{
			startPage = ((int)(currentPage / pageSize )- 1) * pageSize + 1;
		}
		int endPage = startPage + pageSize - 1;	
		if(endPage > pageCount) endPage = pageCount;
		
		request.setAttribute("boardlist", boardList);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "39_showBoardListForCustomer.jsp");		
		System.out.println("===showBoardListForCustomer.do 끝====");
		return "00_index";
	}
	
	@RequestMapping(value="/adminShowBoardContent.do" , method=RequestMethod.GET)
	public String info(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("info num =" + num);
		boardVO bean = boardDAO.getOneBoard(num);
		request.setAttribute("bean", bean);
		request.setAttribute("num", num);
		
		int readcnt = boardDAO.getReadCount(num);
		int updatecnt = readcnt+1;
		bean.setReadcount(updatecnt);
		
		boardDAO.updateReadcount(bean,num);
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "41_adminShowBoardContent.jsp");		
		System.out.println("===showBoardListForCustomer.do 끝====");
		
		return "00_index";
	}
	
	@RequestMapping(value="/showBoardContent.do" , method=RequestMethod.GET)
	public String showBoardContent(Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("===showBoardContent시작===");
		request.setCharacterEncoding("utf-8");		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("info num =" + num);
		boardVO bean = boardDAO.getOneBoard(num);
		request.setAttribute("bean", bean);
		request.setAttribute("num", num);
		
		int readcnt = boardDAO.getReadCount(num);
		int updatecnt = readcnt+1;
		bean.setReadcount(updatecnt);
		
		boardDAO.updateReadcount(bean,num);
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "38_showBoardContent.jsp");		
		System.out.println("===showBoardListForCustomer.do 끝====");
		
		return "00_index";
	}
	
	//================================
	
	@RequestMapping(value = "/write.do", method =  RequestMethod.GET)
	private String writeForm(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("===write.do 시작====");
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "31_write.jsp");		
		System.out.println("===write.do 끝====");
		
		return "00_index";
	}
	
	
	
	@RequestMapping(value="/writePro.do" , method=RequestMethod.POST)
	public String writePro( HttpSession session, Model model, boardVO boardVO ,  HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");		
		System.out.println("===writePro시작====");
		int maxnum = boardDAO.getBoardCount();
		int articleRef = boardDAO.getNewArticleRef();
		boardVO.setNum(maxnum+1);
		boardVO.setRef(articleRef + 1);
		boardVO.setWriter((String)session.getAttribute("id"));
		
		boardDAO.insertNewBoard(boardVO);
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "32_writePro.jsp");		
		System.out.println("===writePro 끝====");
		
		return "00_index";
	}
	
	@RequestMapping(value = "/writeAnswer.do", method =  RequestMethod.GET)
	private String writeAnswer(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("===writeAnswer 시작====");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("writeAnswer num 확인용 = " + num);
		request.setAttribute("num", num);
		
		int ref = boardDAO.getRef(num);
		int re_step = boardDAO.getRe_step(num);
		int re_level = boardDAO.getRe_level(num);
		
		model.addAttribute("ref", ref);
		model.addAttribute("re_step", re_step);
		model.addAttribute("re_level", re_level);
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "36_writeAnswer.jsp");		
		System.out.println("===writeAnswer 끝====");
		
		return "00_index";
	}
	
	@RequestMapping(value="/writeAnswerPro.do" , method=RequestMethod.POST)
	public String writeAnswerPro( boardVO boardVO , Model model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");		
		System.out.println("====writeAnswerPro 시작====");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("writeanswer num = " + num);
		
		
		int ref = boardDAO.getRef(num);
		int re_step = boardDAO.getRe_step(num);
		int re_level = boardDAO.getRe_level(num);
		
		boardVO.setNum(num+1);
		boardVO.setRef(ref);
		boardVO.setRe_step(re_step+1);
		boardVO.setRe_level(re_level+1);
		
		boardDAO.writeAnswer(boardVO);
		
		model.addAttribute("type", new Integer(0));
		model.addAttribute("cont", "37_writeAnswerPro.jsp");		
		System.out.println("===writeAnswerPro 끝====");
		return "00_index";
	}
	
	@RequestMapping(value="/delete.do" , method=RequestMethod.GET)
	public String deleteBoard(Model model,  HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("=======delteBoard 시작========");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println("delteBoard num = " + num);
		boardDAO.deleteBoard(num);
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "33_delete.jsp");
		System.out.println("=======delteBoard 끝========");
		return "00_index";
	}
	
	@RequestMapping(value="/update.do" , method=RequestMethod.GET)
	public String update(Model model,  HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("=======update 시작========");
		int num = Integer.parseInt(request.getParameter("num"));
		boardVO bean = boardDAO.getOneBoard(num);
		request.setAttribute("bean", bean);
		request.setAttribute("num", num);
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "34_update.jsp");
		System.out.println("=======update 끝========");
		return "00_index";
	}
	
	@RequestMapping(value="/updatePro.do" , method=RequestMethod.POST)
	public String updatePro(Model model,  HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("=======updatePro 시작========");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int num = Integer.parseInt(request.getParameter("num"));
		boardVO bean = boardDAO.getOneBoard(num);
		bean.setTitle(title);
		bean.setContent(content);
		
		boardDAO.updateBoard(bean, num);
		
		model.addAttribute("type", new Integer(1));
		model.addAttribute("cont", "35_updatePro.jsp");
		System.out.println("=======updatePro 끝========");
		return "00_index";
	}
	
	
}
