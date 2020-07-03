package com.job.coverletter.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.job.coverletter.Elastic.ElasicrowAPI;
import com.job.coverletter.Elastic.ElasicHighLeverTemplat;
import com.job.coverletter.Elastic.ElasticSpringExampleApplication;
import com.job.coverletter.all.Pagination;
import com.job.coverletter.all.pagination.MariaPagination;
import com.job.coverletter.all.util.MultiRowTarget;
import com.job.coverletter.all.util.MyUtil;
import com.job.coverletter.model.board.dto.BoardDto;
import com.job.coverletter.model.company.biz.CompanyBiz;
import com.job.coverletter.model.company.dto.CompanyDto;
import com.job.coverletter.model.coverletter.biz.CoverLetterBiz;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;
import com.job.coverletter.model.jobcalendar.biz.JobCalendarBiz;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;
import com.job.coverletter.model.qnaboard.biz.QnaBoardBiz;
import com.job.coverletter.model.qnaboard.dto.QnaBoardDto;

@Controller
public class JobController {
	// 취업센터 : 자기소개서 작성, 포폴작성, 스피치
	private Logger logger = LoggerFactory.getLogger(JobController.class);

	@Autowired
	private CoverLetterBiz coverletterBiz;

	@Autowired
	private CompanyBiz companyBiz;

	@Autowired
	private JobCalendarBiz jobcalendarBiz;

	@Autowired
	private QnaBoardBiz qnaboardbiz;

	// 글목록(페이징기능)
	@RequestMapping(value = "/JOB_jobSearch.do", method = RequestMethod.GET)
	public String jobSearchP(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) {

		logger.info("go jobSearch");

		// 총 게시글 수
		int listCnt = companyBiz.companyListCount();

		// pagination 객체생성
		MariaPagination pagination = new MariaPagination();
		// 현재페이지, 각페이지 범위 시작번호, 전체 게시물 수
		pagination.pageInfo(page, range, listCnt);

		List<CompanyDto> companyList = companyBiz.selectList(pagination);

		List<CompanyDto> newCompanyList = new ArrayList<CompanyDto>();

		for (CompanyDto dto : companyList) {
			System.out.println(dto);
			String business = MyUtil.StringCut(45, dto.getBusiness());
			String oneintro = MyUtil.StringCut(50, dto.getOneintro());
			String mainfield = MyUtil.StringCut(50, dto.getMainfield());
			String languages = MyUtil.StringCut(50, dto.getLanguages());
			String location = MyUtil.StringCut(17, dto.getLocation());
			dto.setBusiness(business);
			dto.setOneintro(oneintro);
			dto.setMainfield(mainfield);
			dto.setLanguages(languages);
			dto.setLocation(location);

			newCompanyList.add(dto);
		}

		model.addAttribute("newCompanyList", newCompanyList);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

		return "JOB/jobSearch";
	}

	// ajax 검색기능
	@RequestMapping(value = "/JOB_jobSearchRes.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = "application/text;charset=utf8")
	public @ResponseBody String jobSearchRes(@ModelAttribute CompanyDto jsonKey) {
		logger.info("검색 테스트 : " + jsonKey);
		logger.info("jobSearch");

		ElasicHighLeverTemplat elastic = new ElasicHighLeverTemplat();

		String res = elastic.callSearchQuery(jsonKey);

		return res;
	}

	@RequestMapping(value = "/JOB_jobDetail.do", method = RequestMethod.GET)
	public String jobDetail(Model model, int companyseq) {
		logger.info("jobDetail");
		model.addAttribute("companydto", companyBiz.selectOne(companyseq));

		return "JOB/jobDetail";
	}

	// 즐겨찾기 등록 여부
	@RequestMapping(value = "/JOB_isJobBookmark.do", method = RequestMethod.POST)
	@ResponseBody
	public String isBookmark(@ModelAttribute("companyseq") int companyseq, HttpSession session) {
		logger.info("isJobBookmark");

		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

		JobCalendarDto dto = new JobCalendarDto();
		dto.setCompanyseq(companyseq);
		dto.setJoinemail(userDto.getJoinemail());

		boolean isbookmark = jobcalendarBiz.isJobBookmark(dto);

		if (isbookmark) {
			return "true";
		} else {
			return "false";
		}
	}

	// 즐게찾기 추가 삭제
	@RequestMapping(value = "/JOB_jobBookmark.do", method = RequestMethod.POST)
	@ResponseBody
	public String jobBookmark(@ModelAttribute("companyseq") int companyseq, HttpSession session) {
		logger.info("jobBookmark");
		System.out.println("확인 : " + companyseq);

		CompanyDto companyDto = companyBiz.selectOne(companyseq);
		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

		// 즐겨찾기 등록여부
		JobCalendarDto inputDto = new JobCalendarDto();
		inputDto.setCompanyseq(companyseq);
		inputDto.setJoinemail(userDto.getJoinemail());

		boolean isbookmark = jobcalendarBiz.isJobBookmark(inputDto);

		if (isbookmark) {
			JobCalendarDto dto = new JobCalendarDto();
			dto.setJoinemail(userDto.getJoinemail());
			dto.setCompanyseq(companyseq);
			dto.setCompanyname(companyDto.getCompanyname());
			dto.setBusiness(companyDto.getBusiness());
			dto.setEnddate(companyDto.getEnddate());

			int res = jobcalendarBiz.boardJobInsert(dto);
			if (res > 0) {
				return "insertSuccess";
			} else {
				return "insertFail";
			}
		} else {
			JobCalendarDto deleteDto = new JobCalendarDto();
			deleteDto.setCompanyseq(companyseq);
			deleteDto.setJoinemail(userDto.getJoinemail());

			int res = jobcalendarBiz.bookmarkDelete(deleteDto);
			if (res > 0) {
				return "deleteSuccess";
			} else {
				return "deleteFail";
			}
		}
	}

	@RequestMapping(value = "/JOB_jobCenter.do")
	public String jobCenter() {
		return "JOB/jobCenter";
	}

	@RequestMapping(value = "USER_speechForm.do")
	public String jobSpeech(Model model) {

		int count = qnaboardbiz.boardQnaListCount();
		System.out.println(count);

		model.addAttribute("count", count);
		return "USER/userSpeech";
	}

	// PFwrite page go
	@RequestMapping(value = "/USER_userPFwrite.do")
	public String PFwrite(Model model) {
		logger.info("PRwrite go");

		MultiRowTarget targets = new MultiRowTarget();
		model.addAttribute("MultiRowTarget", targets);
		return "USER/userPFwrite";
	}

	// 포폴작성
	@RequestMapping(value = "/PFinsert.do", method = { RequestMethod.POST }, consumes = { "multipart/form-data" })
	public String PFinsert(Model model, @ModelAttribute("MultiRowTarget") @Valid MultiRowTarget targets,
			BindingResult result, MultipartHttpServletRequest mprequest, HttpSession session) {
		logger.info("PFinsert");

		JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
		logger.info("확인22222222222!!!!!!!!!!!!!!!!!!!!!" + userDto);

		// 가장 큰 그룹번호 가져오기
		int groupno = coverletterBiz.getGroupno(userDto.getJoinemail()).getGroupno();
		groupno += 1;

		logger.info("확인!!!!!!!!!!!!!!!!!!!!!" + groupno);

		List<MultipartFile> list =  targets.getTargets().get(0).getFileUpload();
		System.out.println("파일의 개수 : " + list.size());

		InputStream inputStream = null;
		OutputStream outputStream = null;

		for (int y = list.size() - 1; y >= 0; y--) {
			MultipartFile file = list.get(y);

			if (file.getSize() == 0) {
				list.remove(y);
				continue;
			}
			String name = file.getOriginalFilename();

			System.out.println("----------------------------------------");

			System.out.println("file = " + file.getSize());
			try {
				System.out.println("file = " + file.getInputStream());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("name = " + name);

			try {
				inputStream = file.getInputStream();
				// 경로
				String path = WebUtils.getRealPath(mprequest.getSession().getServletContext(), "/storage");
				System.out.println("upload real path : " + path);

				File storage = new File(path);
				if (!storage.exists()) {
					storage.mkdir();
				} // 해당 파일이 있으면 넘어간다.

				File newFile = new File(path + "/" + name);
				if (!newFile.exists()) {
					newFile.createNewFile();
				} // 새로운 파일이 없으면

				outputStream = new FileOutputStream(newFile); // 업로드 되는 파일
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

			System.out.println("if문 들어왔다lo");

			for (int i = 0; i < targets.getTargets().size(); i++) {

				String title = targets.getTargets().get(0).getTitle();
				String subtitle = targets.getTargets().get(0).getSubtitle();
				String question = targets.getTargets().get(0).getQuestion();
				String content = targets.getTargets().get(0).getContent();
				String functions = targets.getTargets().get(0).getFunctions();
				String positions = targets.getTargets().get(0).getPositions();
				String participation = targets.getTargets().get(0).getParticipation();

				targets.getTargets().get(i).setTitle(title);
				targets.getTargets().get(i).setSubtitle(subtitle);
				targets.getTargets().get(i).setQuestion(question);
				targets.getTargets().get(i).setContent(content);
				targets.getTargets().get(i).setFunctions(functions);
				targets.getTargets().get(i).setPositions(positions);
				targets.getTargets().get(i).setParticipation(participation);
				targets.getTargets().get(i).setFilepath(name);
				targets.getTargets().get(i).setJoinemail(userDto.getJoinemail());
				targets.getTargets().get(i).setGroupno(groupno);
				System.out.println("========================insert 이전 dto 값 : " + targets.getTargets().get(i));
				coverletterBiz.PFwrite(targets.getTargets().get(i));
				System.out.println("========================dto 값 : " + targets.getTargets().get(i));

			}
		}

		return "redirect:/USER_userPFList.do";
	}
}