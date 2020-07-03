package com.job.coverletter.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.job.coverletter.all.Pagination;
import com.job.coverletter.model.board.biz.BoardBiz;
import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;

@Controller
public class BoardController {
	// 게시판
	private Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardBiz boardBiz;

	// 로그인 기능 완성되면 로그인 세션에 있는 아이디로 바꿔야됨
	// 글목록(페이징기능)
	@RequestMapping(value = "/BOARD_boardList.do", method = RequestMethod.GET)
	public String boardList(@ModelAttribute("BoardDto") BoardDto dto, @RequestParam(defaultValue = "1") int curPage,
			HttpServletRequest request, Model model) {

		// 총 게시글 수
		int listCnt = boardBiz.boardListCount(dto);

		// 페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
		Pagination pagination = new Pagination(listCnt, curPage);
		dto.setStartIndex(pagination.getStartIndex());
		dto.setCntPerPage(pagination.getPageSize() * curPage);

		List<BoardDto> list = boardBiz.boardList(dto);

		model.addAttribute("boardList", list);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

		return "BOARD/boardList";
	}

	// 글작성 페이지
	@RequestMapping(value = "/BOARD_boardWriteForm.do", method = RequestMethod.GET)
	public String boardWriteForm() {
		return "BOARD/boardWrite";
	}

	// 글작성
	@RequestMapping(value = "/BOARD_boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(@ModelAttribute("BoardDto") BoardDto dto, HttpServletRequest request , HttpSession session) {
		
		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
		String login = userDto.getJoinemail();
		
		logger.info("dto 확인 >>>>>>>>>>>>>> " + dto);	// view에서 dto의 Multipartfile속성에 파일이 담겨져서 온다 
		
		MultipartFile file = dto.getUploadFile();	// 스프링에서 제공하는 인터페이스, dto(file)에서 multipartFile를 가져온다.	
		if (file.getSize() != 0) {					// 파일이 들어왔다면
			String name = file.getOriginalFilename();	
			System.out.println("----------------------------------------");
			System.out.println("file = " + file.getSize());
			try {
				System.out.println("file = " + file.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("name = " + name);

//			이름과 설명을 넘김.

			InputStream inputStream = null;
			OutputStream outputStream = null;

			try {
				inputStream = file.getInputStream();
				// 경로 >>> C:\final_project\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\final_coverletter\storage
				String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
				System.out.println("upload real path : " + path);

				File storage = new File(path);
				if (!storage.exists()) {
					storage.mkdir(); 		// 해당 경로에 폴더를 생성
					//storage.mkdirs		// 해당 경로에 상위 폴더외 해당폴더를 모두 생성한다. 
				} 

				File newFile = new File(path + "/" + name);
				if (!newFile.exists()) {
					newFile.createNewFile();	// 파일객체의 주어진 경로  + 이름의 파일이 없으면 새로 생성한다.
				}

				outputStream = new FileOutputStream(newFile); // 새로만든 파일

				int read = 0;
				byte[] b = new byte[(int) file.getSize()];
				while ((read = inputStream.read(b)) != -1) {
					outputStream.write(b, 0, read);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("if문 들어왔다");
			dto.setFilepath(name);
			dto.setJoinemail(login);

			int res = boardBiz.boardInsert(dto);
			if (res > 0) {
				return "redirect:/BOARD_boardList.do";
			} else {
				return "redirect:/BOARD_boardWriteForm.do";
			}
		} else {
			System.out.println("else문 들어왔다");
			String name = "";
			dto.setFilepath(name);
			dto.setJoinemail(login);

			int res = boardBiz.boardInsert(dto);
			if (res > 0) {
				return "redirect:/BOARD_boardList.do";
			} else {
				return "redirect:/BOARD_boardWriteForm.do";
			}
		}

	}

	// 글상세 + 댓글상세
	@RequestMapping(value = "/BOARD_boardDetail.do", method = RequestMethod.GET)
	public String boardDetail(Model model, @ModelAttribute("BoardDto") BoardDto dto, int curPage) {
		// 글
		BoardDto boardDetail = boardBiz.boardDetail(dto);
		// 댓글
		List<BoardDto> replyList = boardBiz.replyList(dto);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("replyList", replyList);
		model.addAttribute("curPage", curPage);
		return "BOARD/boardDetail";
	}

	// 글수정 페이지
	@RequestMapping(value = "/BOARD_boardUpdateForm.do")
	public String boardUpdateForm(Model model, int boardseq, int curPage) {
		BoardDto dto = new BoardDto();
		dto.setBoardseq(boardseq);
		BoardDto boardDetail = boardBiz.boardDetail(dto);
		boardDetail.setCurPage(curPage);
		model.addAttribute("boardDetail", boardDetail);
		return "BOARD/boardUpdate";
	}

	// 글수정
	@RequestMapping(value = "/BOARD_boardUpdate.do", method = RequestMethod.POST)
	public String boardUpdate(Model model, @ModelAttribute("BoardDto") BoardDto dto) {
		int res = boardBiz.boardUpdate(dto);
		if (res > 0) {
			return "redirect:/BOARD_boardList.do?curPage=" + dto.getCurPage();
		} else {
			return "redirect:/BOARD_boardWriteForm.do";
		}
	}

	// 글삭제
	@RequestMapping(value = "/BOARD_boardDelete.do")
	public String boardDelete(int groupno) {
		boardBiz.boardDelete(groupno);
		return "redirect:/BOARD_boardList.do";
	}

	// 댓글작성
	@RequestMapping(value = "/BOARD_replyInsert.do")
	public String replyInsert(@ModelAttribute("BoardDto") BoardDto dto, int curPage, Model model , HttpSession session) {
		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
		String login = userDto.getJoinemail();
		// 댓글작성자 : 로그인 완성되면 로그인 세션 아이디로 바꿔야됨
		dto.setJoinemail(login);
		boardBiz.replyInsert(dto);

		return "redirect:/BOARD_boardDetail.do?boardseq=" + dto.getBoardseq() + "&groupno=" + dto.getGroupno()
				+ "&curPage=" + curPage;
	}

	// 대댓글작성
	@RequestMapping(value = "/BOARD_rereInsert.do")
	public String rereInsert(@ModelAttribute("BoardDto") BoardDto dto, int parentboardseq, int curPage, Model model , HttpSession session) {
		// 댓글작성자 : 로그인 완성되면 로그인 세션 아이디로 바꿔야됨
		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
		String login = userDto.getJoinemail();
		dto.setJoinemail(login);
		boardBiz.rereInsert(dto);

		return "redirect:/BOARD_boardDetail.do?boardseq=" + parentboardseq + "&groupno=" + dto.getGroupno()
				+ "&curPage=" + curPage;
	}

	// 댓글삭제
	@RequestMapping(value = "/BOARD_replyDelete.do")
	public String replyDelete(@ModelAttribute("BoardDto") BoardDto dto, int parentboardseq, int curPage, Model model) {
		boardBiz.replyDelete(dto.getBoardseq());

		return "redirect:/BOARD_boardDetail.do?boardseq=" + parentboardseq + "&groupno=" + dto.getGroupno()
				+ "&curPage=" + curPage;
	}

	// 에러
	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public void errpage() throws Exception {
		logger.info("예외 발생");
		throw new Exception();
	}

	// 파일 다운로드
	@RequestMapping(value = "/download.do", method = RequestMethod.POST)
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
//연속적인 바이트들의 흐름 : byte[] 
		byte[] down = null;
		String path;

		try {
			path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");

			File file = new File(path + "/" + name);

			down = FileCopyUtils.copyToByteArray(file);		
			String filename = new String(file.getName().getBytes(), "8859_1");

			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
			//response.setContentType("application/octet-stream"); 			// # application/octet-stream는 다른 모든 경우를 위한 기본값입니다. ,알려지지 않은 파일 타입은 이 타입을 사용해야 합니다
			response.setContentLength(down.length);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return down;
	}
}
