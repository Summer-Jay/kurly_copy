package com.myspring.kurly.manager.item;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository("managerItemDAO")
public class managerItemDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	 public List<managerItemVO> getAllItem() throws DataAccessException{ 
		 List<managerItemVO> list = sqlSession.selectList("mapper.item.getAllItem"); 
		 return list; 
	 }
	 
	 public List<managerItemVO> getBestItem() throws DataAccessException{ 
		 List<managerItemVO> list = sqlSession.selectList("mapper.item.getBestItem"); 
		 return list; 
	 }
	 
	 public List<managerItemVO> getNewItem() throws DataAccessException{ 
		 List<managerItemVO> list = sqlSession.selectList("mapper.item.getNewItem"); 
		 return list; 
	 }
	 
	 public List<managerItemVO> getDiscountedItem() throws DataAccessException{ 
		 List<managerItemVO> list = sqlSession.selectList("mapper.item.getDiscountedItem"); 
		 return list; 
	 }
	 
	 public List<managerItemVO> getOneItem(int item_number) throws DataAccessException{ 
		 List<managerItemVO> list = sqlSession.selectList("mapper.item.getOneItem", item_number); 
		 return list; 
	 }
	 
	 public int getSold(String item_name) throws DataAccessException{
		 int sold = sqlSession.selectOne("mapper.item.getSold", item_name);
		 return sold;
	 }
	 
	 public int getStock(String item_name) throws DataAccessException{
		 int stock = sqlSession.selectOne("mapper.item.getStock", item_name);
		 return stock;
	 }
	 
	 public void updateSold(managerItemVO vo, String item_name) throws DataAccessException{
		 vo.setItem_name(item_name);
		 sqlSession.update("mapper.item.updateSold", vo);
	 }
	 
	 public managerItemVO getOneItembyName(String item_name) throws DataAccessException{
		 managerItemVO vo = sqlSession.selectOne("mapper.item.getOneItembyName", item_name);
		 return vo;
	 }
	 
	 public int getitemcnt() throws DataAccessException{
		 int cnt = sqlSession.selectOne("mapper.item.getitemcnt");
		 return cnt;
	 }
	 
	 public void deleteItem(int item_number) throws DataAccessException{
		 sqlSession.delete("mapper.item.deleteItem", item_number);
	 }
	  
	 public void updateItem(managerItemVO item, int item_number) throws DataAccessException{
		 item.setItem_number(item_number);
		 sqlSession.update("mapper.item.updateItem", item);
	 }
	 
	 public void addNewItem(managerItemVO item) throws DataAccessException{

		 sqlSession.insert("mapper.item.registItem", item);
	 }
}
