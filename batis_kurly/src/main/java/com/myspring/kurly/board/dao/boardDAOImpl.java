package com.myspring.kurly.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.kurly.board.vo.boardVO;

@Repository("boardDAOImpl")
public class boardDAOImpl implements boardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int getBoardCount() throws DataAccessException{
		return sqlSession.selectOne("mapper.board.selectBoardCount");
	}
	
	@Override
	public List getBoardListCurrentPage(int startRow, int pageSize) throws DataAccessException {
		
		Map<String , Object> hashMap = new HashMap<String, Object>();
		hashMap.put("starRow" , startRow);
		hashMap.put("pageSize" , pageSize);
		List<boardVO> boardList  = sqlSession.selectList("mapper.board.selectBoardListCurrentPage" , hashMap);
		return boardList;
	}
	
	@Override
	public int getNewArticleRef() throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectNewArticleRef");
	}	
	
	@Override
	public int getRef(int num) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.getRef", num);
	}
	
	@Override
	public int getRe_step(int num) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.getRe_step", num);
	}
	
	@Override
	public int getRe_level(int num) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.getRe_level", num);
	}
	
	@Override
	public int getReadCount(int num) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.getReadCount", num);
	}
	
	@Override
	public void insertNewBoard(boardVO boardVO) throws DataAccessException {
		sqlSession.insert("mapper.board.insertNewArticle",boardVO);
	}
	
	@Override
	public boardVO getOneBoard(int num) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.selectOneArticle" , num);
	}
	
	@Override
	public boardVO deleteBoard(int num) throws DataAccessException {
		return sqlSession.selectOne("mapper.board.deleteBoard" , num);
	}
	
	@Override
	public void updateReadcount(boardVO board, int num) throws DataAccessException {
		board.setNum(num);
		sqlSession.update("mapper.board.updateReadcount" , board);
	}
	
	@Override
	public void writeAnswer(boardVO boardVO) throws DataAccessException {
		sqlSession.insert("mapper.board.writeAnswer",boardVO);                                
	}
	
	@Override
	public void updateBoard(boardVO board, int num) throws DataAccessException {
		board.setNum(num);
		sqlSession.update("mapper.board.updateBoard", board);                                
	}
}
