package com.itwllbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 서비스 객체 주입
	@Inject
	private BoardService bService;
	
	// http://localhost:8088/board/regist
	// 게시판 글쓰기 - GET
	@RequestMapping(value = "/regist",method = RequestMethod.GET)
	public void registGET() throws Exception {
		logger.debug("게시판 글쓰기 GET - 사용자의 정보 입력");
		logger.debug("연결된 view 페이지 이동");
		
	}
	
	// 게시판 글쓰기 - POST
	@RequestMapping(value = "/regist",method = RequestMethod.POST)
	public String registPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
		logger.debug("게시판 글쓰기 POST - 입력된 데이터 처리");
		// 한글인코딩(필터 처리)
		// 전달정보 저장
		logger.debug("vo : "+ vo);
		
		// 서비스 -> DAO에 동작 호출
		bService.regist(vo);

		// 글쓰기 성공정보를 전달
		rttr.addFlashAttribute("msg", "createOK");
		
		// 페이지 이동
		return "redirect:/board/listAll";
		//return "redirect:/board/listAll?msg=createOK";
		//return "redirect:/board/list";
	}
	
	// * 정보조회 동작, 사용자 정보 입력 => GET 방식
	// * 정보를 처리하는 동작(UPDATE, DELETE, INSERT) => POST 방식
	
	// 게시판 글목록 조회 - GET
	@RequestMapping(value = "/listAll",method = RequestMethod.GET)
	public String listAllGET(Model model) throws Exception {
		logger.debug("/listAll -> listAllGET(Model model) 호출");
		
		// 서비스 -> DB의 정보를 가져오기
		List<BoardVO> boardList = bService.listAll();
		logger.debug("size : " + boardList.size());
		
		// 연결되 뷰페이지로 정보 전달
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	// http://localhost:8088/board/read?bno=1
	// 게시판 본문 보기 - readGET
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void readGET(@ModelAttribute("bno") int bno, Model model) throws Exception { 
		
		// @RequestParam, @ModelAttribute의 차이
		
		// @ModelAttribute("bno") int bno
		// => 주소줄에 있는 데이터를 가져와서 사용, 연결된 뷰페이지로 이동 $ {bno}
		// 	  request.getParameter("bno") + request.setAttribute();
		// => 1:N 관계에서 사용( N - bean(객체), collection)
		
		// @RequestParam("bno") int bno
		// => request.getParameter("bno") 동일함. 자동형변환 포함(문자,숫자,날짜) (원래 request.getParameter()는 String 타입)
		// => 1:1 관계에서 사용.
		
		logger.debug("readGET() 실행");
		
		// 전달정보 저장
		logger.debug("bno : " + bno);
		
		// 글 조회(읽음) 카운트 증가 => 조회수 1증가
		bService.upupdateReadCnt(bno);
		
		// 서비스 -DAO 저장된 정보를 가져오기
		BoardVO resultVO = bService.getPage(bno);
		logger.debug("resultVO : {}", resultVO);
		
		// 전달할 정보를 저장
		model.addAttribute("resultVO", resultVO);
		// 연결된 뷰페이지 이동
		
	}
}
