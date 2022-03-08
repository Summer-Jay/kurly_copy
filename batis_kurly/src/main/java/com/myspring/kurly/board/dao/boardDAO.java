package com.myspring.kurly.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.kurly.board.vo.boardVO;

public interface boardDAO {

	public int getBoardCount() throws DataAccessException;
	public List getBoardListCurrentPage(int startRow, int pageSize) throws DataAccessException;
	public int getNewArticleRef() throws DataAccessException;
	public int getRef(int num) throws DataAccessException;
	public int getRe_step(int num) throws DataAccessException;
	public int getRe_level(int num) throws DataAccessException;
	public int getReadCount(int num) throws DataAccessException;
	public void insertNewBoard(boardVO boardVO) throws DataAccessException;
	public boardVO getOneBoard(int num) throws DataAccessException;
	public boardVO deleteBoard(int num) throws DataAccessException;
	public void updateReadcount(boardVO board, int num) throws DataAccessException;
	public void writeAnswer(boardVO boardVO) throws DataAccessException;
	public void updateBoard(boardVO board, int num) throws DataAccessException;

}
