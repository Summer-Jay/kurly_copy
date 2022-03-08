package com.myspring.kurly.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.kurly.manager.item.managerItemVO;
import com.myspring.kurly.member.vo.memberVO;


@Repository("memberDAO")
public class memberDAOImpl implements memberDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public memberVO loginById(memberVO memberVO) throws DataAccessException {
		  memberVO vo = sqlSession.selectOne("mapper.member.loginById",memberVO);
			return vo;
	}
	
	@Override
	public int insertMember(memberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember",memberVO);
			return result;
	}
	
	public List<memberVO> getMemberInfo(String id) throws DataAccessException{
		List<memberVO> list = sqlSession.selectList("mapper.member.getMemberInfo", id);
		return list;
	}
	
	public int getmembercnt() throws DataAccessException{
		int cnt = sqlSession.selectOne("mapper.member.getmembercnt");
		return cnt;
	}
	
}
