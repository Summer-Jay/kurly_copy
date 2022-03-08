package com.myspring.kurly.manager;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("managerDAO")
public class managerDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public String loginById(String id) {
		String pw = sqlSession.selectOne("mapper.manager.loginById", id);
		return pw;
	}
}
