package com.myspring.kurly.member.service;

import java.util.List;

import com.myspring.kurly.manager.item.managerItemVO;
import com.myspring.kurly.member.vo.memberVO;

public interface memberService {

	public memberVO login(memberVO memberVO) throws Exception;
	public int addMember(memberVO memberVO) throws Exception;

}
