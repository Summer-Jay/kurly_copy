package com.myspring.kurly.buy;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("buyDAO")
public class buyDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public void insertOrderList(buyVO vo) {
		sqlSession.insert("mapper.buy.insertOrderList", vo);
	}
	
	public List<buyVO> getBuyList(String customer_id){
		List<buyVO> list = sqlSession.selectList("mapper.buy.getBuyList", customer_id);
		
		return list;
	}
	
	public List<buyVO> getAllBuyList(){
		List<buyVO> list = sqlSession.selectList("mapper.buy.getAllBuyList");
		
		return list;
	}
	
	public int getbuycnt() {
		int cnt = sqlSession.selectOne("mapper.buy.getbuycnt");
		return cnt;
	}
}
