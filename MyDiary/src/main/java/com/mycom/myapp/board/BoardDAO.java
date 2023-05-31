package com.mycom.myapp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//데이터베이스와 상호작용하여 게시글을 생성, 조회, 수정, 삭제하는 기능
//BoardDAO는 BoardController에서 호출되어 게시글 관련 요청을 처리
@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;

	// 게시글을 추가합니다.
	public int insertBoard(BoardVO vo) {
		int result = sqlSession.insert("Board.insertBoard", vo);
		return result;
	}

	// 특정 게시글을 조회합니다.
	public BoardVO getBoard(int seq) {
		BoardVO one = sqlSession.selectOne("Board.getBoard", seq);
		return one;
	}

	// 모든 게시글 목록을 조회합니다.
	public List<BoardVO> getBoardList() {
		List<BoardVO> list = sqlSession.selectList("Board.getBoardList");
		return list;
	}

	// 특정 게시글을 삭제합니다.
	public int deleteBoard(int id) {
		int result = sqlSession.delete("Board.deleteBoard", id);
		return result;
	}

	// 게시글을 수정합니다.
	public int updateBoard(BoardVO vo) {
		int result = sqlSession.update("Board.updateBoard", vo);
		return result;
	}

}