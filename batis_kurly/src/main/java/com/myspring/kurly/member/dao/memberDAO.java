package com.myspring.kurly.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kurly.manager.item.managerItemVO;
import com.myspring.kurly.member.vo.memberVO;

public interface memberDAO {


	public memberVO loginById(memberVO memberVO) throws DataAccessException;
	public int insertMember(memberVO memberVO) throws DataAccessException;

}
