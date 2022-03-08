package com.myspring.kurly.cart;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.kurly.cart.cartVO;

@Repository("cartDAO")
public class cartDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<cartVO> getCartList(String buyer){
		List<cartVO> list = sqlSession.selectList("mapper.cart.getCartList",buyer); 
		 return list; 
	}
	
	public int getMaxCartNumber() {
		int max = sqlSession.selectOne("mapper.cart.getMaxCartNumber");
		return max;
	}
	
	public void insertCart(cartVO vo) {
		sqlSession.insert("mapper.cart.insertCart", vo);
	}
	
	public int getCnt(String buyer) {
		int cnt = sqlSession.selectOne("mapper.cart.getCnt", buyer);
		return cnt;
	}
	
	public void deleteCart(int cart_number) {
		sqlSession.delete("mapper.cart.deleteCart", cart_number);
	}
	
	public void deleteCartList(String buyer) {
		sqlSession.delete("mapper.cart.deleteCartList",buyer);
	}
} 
