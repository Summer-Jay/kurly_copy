package com.myspring.kurly.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.kurly.manager.item.managerItemVO;
import com.myspring.kurly.member.dao.memberDAO;
import com.myspring.kurly.member.vo.memberVO;

@Service("memberService")
public class memberServiceImpl implements memberService{
	@Autowired
	private memberDAO memberDAO;

	@Override
	public memberVO login(memberVO memberVO) throws Exception {
		return memberDAO.loginById(memberVO);
	}
	
	@Override
	public int addMember(memberVO memberVO) throws Exception {
		return memberDAO.insertMember(memberVO);
	}
	
	
	
	
}
