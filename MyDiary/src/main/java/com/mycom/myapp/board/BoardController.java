package com.mycom.myapp.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//MyDiary 웹 앱의 게시판 기능을 구현
@Controller
public class BoardController {
	@Autowired
	BoardDAO boardDAO;
	
	// 게시글 목록을 가져와서 list.html에 전달합니다.
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardlist(Model model) {
		model.addAttribute("list", boardDAO.getBoardList() );
		return "list";
	}
	
	// 게시글 작성 폼으로 이동합니다.
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addPostForm() {
		return "addpostform";
	}
	
	// 게시글을 추가합니다.
	@RequestMapping(value = "addok", method = RequestMethod.POST)
	public String addPostOK(BoardVO vo) {
		int i = boardDAO.insertBoard(vo);
		if (i == 0)
			System.out.println("데이터 추가 실패...!");
		else
			System.out.println("데이터 추가 성공...!");
		return "redirect:list";
	}
	
	// 특정 게시글의 수정 폼으로 이동합니다.
	@RequestMapping(value = "/editpost/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardDAO.getBoard(id);
		System.out.println(boardVO.getSeq());
		model.addAttribute("u", boardVO);
		return "editform";
	}
	
	// 특정 게시글의 상세 정보를 조회합니다.
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id, Model model) {
		BoardVO boardVO = boardDAO.getBoard(id);
		model.addAttribute("boardVO", boardVO);
		return "detail";
	}
	
	// 게시글을 수정합니다.
	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editPostOK(BoardVO vo) {
		int i = boardDAO.updateBoard(vo);
		if (i == 0)
			System.out.println("데이터 수정 실패...!");
		else
			System.out.println("데이터 수정 성공...!");
		return "redirect:list";
	}
	
	// 게시글을 삭제합니다.
	@RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
	public String deletePostOK(@PathVariable("id") int id) {
		int i = boardDAO.deleteBoard(id);
		if (i == 0)
			System.out.println("데이터 삭제 실패...!");
		else
			System.out.println("데이터 삭제 성공...!");
		return "redirect:../list";
	}
}