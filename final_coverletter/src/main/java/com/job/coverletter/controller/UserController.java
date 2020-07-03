package com.job.coverletter.controller;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.aspectj.org.eclipse.jdt.internal.compiler.batch.Main;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.google.gson.JsonObject;
import com.job.coverletter.all.Pagination;
import com.job.coverletter.all.util.MultiRowTarget;
import com.job.coverletter.model.coverletter.biz.CoverLetterBiz;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;
import com.job.coverletter.model.jobcalendar.biz.JobCalendarBiz;
import com.job.coverletter.model.jobcalendar.dto.JobCalendarDto;
import com.job.coverletter.model.joinUser.biz.JoinUserBiz;
import com.job.coverletter.model.joinUser.biz.JoinUserBizImpl;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;
import com.job.coverletter.model.qnaboard.biz.QnaBoardBiz;
import com.job.coverletter.model.qnaboard.dto.QnaBoardDto;
import com.job.coverletter.model.school.dto.SchoolDto;
import com.job.coverletter.model.total.biz.TotalBiz;
import com.job.coverletter.model.total.biz.TotalBizImpl;
import com.job.coverletter.model.total.dto.TotalDto;
import com.job.coverletter.model.skill.biz.SkillBiz;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class UserController {
   // 로그인, 회원가입, 마이페이지, 이력작성, 캘린더, 관심공고, 비번
   private Logger logger = LoggerFactory.getLogger(UserController.class);

   @Autowired
   private JoinUserBiz joinUserBiz;

   @Autowired
   private TotalBiz totalBiz;

   @Autowired
   private JobCalendarBiz jobCalendarBiz;

   String cvcategory = "";
   @Autowired
   private CoverLetterBiz coverletterBiz;

   @Autowired
   private QnaBoardBiz qnaboardbiz;

   // ==================================================================================

   // join go
   @RequestMapping(value = "/USER_join.do", method = RequestMethod.GET)
   public String join(Model model) {
      logger.info("joinpage go");
      
      model.addAttribute("joinUserDto",new JoinUserDto());
      return "MAIN/join";
   }

   // 회원가입 res
   @RequestMapping(value = "/USER_joinRes.do", method = RequestMethod.POST)
   public String joinRes(Model model, @ModelAttribute("joinUserDto") @Valid JoinUserDto dto, BindingResult result) throws Exception {
      logger.info("joinRes.do");

      model.addAttribute("joinUserDto", dto);

      System.out.println("===============joinuserDto" + dto);

      if (result.hasErrors()) {

         logger.info("유효성검사실행");
         List<ObjectError> list = result.getAllErrors();
         for (ObjectError error : list) {
            System.out.println(error);
         }
         return "MAIN/join";

      } else {
         logger.info("유효성검사통과");
         int res = joinUserBiz.insertUser(dto);

         if (res > 0) {
        	// setTotalDto() => 가입시킨 유저정보를 사용하여 TotalDto생성
            int totalRes = totalBiz.ToTalInsert(setTotalDto(dto));

            if (totalRes > 0) {
               logger.info("Total 테이블 추가 성공");
               return "MAIN/login";
            } else {
               logger.info("Total 테이블 추가 실패");
               return "MAIN/login";
            }
         } else {
            return "MAIN/join";
         }
      }
   }

   // 회원가입용 이메일 인증 팝업
   @RequestMapping(value = "/USER_emailcheckpopup.do", method = RequestMethod.GET)
   public String emailpopup() {
      logger.info("회원가입 이메일 인증 팝업!");
      return "MAIN/emailChk";
   }

   // 이메일 전송 화면으로
   @RequestMapping(value = "/USER_mailSend.do", method = RequestMethod.POST)
   public String mailSend(Model model, String EmailName) {
      logger.info("mailSend");
      model.addAttribute("EmailName", EmailName);
      return "MAIN/mailSend";
      
  		/*
		 * 의문 : 
		 * 1. emailChk.jsp에서  form태그의 action의로 /USER_mailSend.do url을 지정 값을 컨트롤러로 전달 
		 * 2. 전달받은 값은 EmailName(인증번호 보낼 이메일)과 number(인증번호)이다.
		 * 3. 하지만 컨트롤러에서 받아서 ModelAndVeiw로 전달한 값은 EmailName(인증번호 보낼 이메일) 뿐이다. 
		 * 문제 >> 4. mailSend.jsp에서 보내지도 않은 number(인증번호)를 받아서 사용이 가능하다.
		 * 추측 >> model에서 자동으로 값을 넘겨주고 있는것이 아닐까?
		 */
   }

   // email중복체크
   @RequestMapping(value = "/USER_emailcheck.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
   @ResponseBody
   public String checkemail(@ModelAttribute("joinemail") String joinemail) {
      logger.info("이메일중복체크");
      String res = joinUserBiz.checkemail(joinemail);

      if (res != "중복") {
         return res;
      } else {
         return res;
      }
   }

   // login
   @RequestMapping(value = "/USER_login.do")
   public String login() {
      logger.info("login page");

      return "MAIN/login";
   }

   @RequestMapping(value = "/USER_loginAjax.do", method = RequestMethod.POST, produces = "application/json; charset=utf8", headers = "content-type=application/json")
   @ResponseBody
   public Map<String, Boolean> loginAjax(HttpSession session, @RequestBody JoinUserDto dto) {

      logger.info("login ajax로 넘겨주는 controller : " + dto);
      
      JoinUserDto loginDto = joinUserBiz.login(dto);

      boolean check = false;

      if (loginDto != null) {
         session.setAttribute("login", loginDto);
         logger.info("login session 추가 =>>>>>>>>>>>>>>>>>>" + session.getAttribute("login")); 
         check = true;
      }
      Map<String, Boolean> map = new HashMap<String, Boolean>();
      map.put("check", check);
      return map;
   }

   // sns로그인
   @RequestMapping(value = "/USER_snslogin.do", method = RequestMethod.POST)
   public String snslogin(HttpSession session, JoinUserDto dto) throws Exception {
      logger.info("sns로그인");
      logger.info("=========dto: " + dto);
      JoinUserDto login = null;
      
      // 이메일로 가입 유무체크
      JoinUserDto onelogin = joinUserBiz.selectOne(dto.getJoinemail());
      logger.info("******onelogin: " + onelogin);
      
      // 기존에 가입된 이메일 이면 >> 로그인
      if (onelogin != null) {
    	 login = joinUserBiz.login(dto); 		// 로그인 id : pw
         session.setAttribute("login", login);	// 세션 할당
         logger.info("sns login session 추가 =>>>>>>>>>>>>>>>>>>" + session.getAttribute("login")); 
         return "redirect:MAIN_main.do";
      // 새로운 유저라면 >> insert >> 로그인
      } else {
         int snsjoin = joinUserBiz.insertUser(dto); // 추가
         if (snsjoin > 0) {
        	logger.info("insert =========================> sns최초 로그인 insert success");
        	int res = totalBiz.ToTalInsert(setTotalDto(dto)); // 토탈정보 추가
        	if(res > 0) {
        		logger.info("TotalDto insert =========================> totalDto insert success");
        		login = joinUserBiz.login(dto);		  // 로그인
        		session.setAttribute("login", login); // 세션 할당
        		logger.info("sns login session 추가 =>>>>>>>>>>>>>>>>>>" + session.getAttribute("login")); 
        		return "redirect:MAIN_main.do";
        	} else {
        		// 완벽하게 하려면 추가된 joinUserDto 삭제해야함 biz에서 트렌젝션 처리
        		logger.info("TotalDto insert =========================> totalDto insert fail");
        		return "MAIN/login";
        	}
         } else {
            return "MAIN/login";
         }
      }
   }

   // 아이디 찾기 이메일 인증 팝업
   @RequestMapping(value = "/USER_emailcheckpopup_login.do", method = RequestMethod.GET)
   public String emailpopup_login() {
      logger.info("아이디찾기 이메일 인증 팝업!");
      return "MAIN/emailChk_login";
   }

   // 아이디비밀번호찾기(비밀번호 수정)
   @RequestMapping(value = "/USER_changepw.do", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
   public String findidpw(Model model, JoinUserDto dto) {
      logger.info("아이디 비밀번호 찾기" + dto);
      int res = joinUserBiz.updateJoinuser(dto);

      if (res > 0) {
         logger.info("비밀번호 변경 성공");
         return "MAIN/login";
      } else {
         logger.info("비밀번호 변경 실패");
         model.addAttribute("joinuserDto", dto);
         return "redirect:MAIN_main.do";
      }

   }

   // 로그아웃
   @RequestMapping(value = "/USER_logout.do", method = RequestMethod.GET)
   public String logout(HttpSession session) {
      logger.info("logout");

      session.invalidate();

      return "redirect:MAIN_main.do";
   }

   /*-----------------------비밀번호 변경----------------------*/
   @RequestMapping(value = "USER_PwChange.do", method = RequestMethod.POST)
   @ResponseBody
   public String Pwchange(HttpServletRequest request) {
      String pw = request.getParameter("pw");
      String pwConfirm = request.getParameter("pwConfirm");
      String email = request.getParameter("email");
      JoinUserDto dto = new JoinUserDto(email, pw);

      int res = 0;
      if (pw.equals(pwConfirm)) {

         res = joinUserBiz.updateJoinuser(dto);
         if (res > 0) {
            return "true";
         } else {
            return "false";
         }
      } else {
         return "cancle";
      }
   }

   /*----------------------회원탈퇴--------------------*/
   @RequestMapping(value = "USER_withdraw.do")
   public String withdraw(HttpSession session) {
      logger.info("USER_withdraw");
      JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
      int res = joinUserBiz.deletejoinuser(userDto.getJoinemail());
      if (res > 0) {
         return "redirect:MAIN_main.do";
      } else {
         return "USER_userMain.do";
      }
   }

   // 마이페이지
   @RequestMapping(value = "/USER_userMain.do", method = RequestMethod.GET)
   public String userMain(Model model, HttpSession session) {
      logger.info("userMain go");

      JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
      
      CoverLetterDto cvdto = new CoverLetterDto();
      cvdto.setCvcategory("자소서");
      cvdto.setJoinemail(userDto.getJoinemail());
      int cvlist = coverletterBiz.boardCVListCount(cvdto);
      System.out.println("cvlist : " + cvlist);
      CoverLetterDto pfdto = new CoverLetterDto();
      pfdto.setCvcategory("포폴");
      pfdto.setJoinemail(userDto.getJoinemail());
      int pflist = coverletterBiz.boardPFListCount(pfdto);
      System.out.println("pflist : " + pflist);

      JobCalendarDto jbdto = new JobCalendarDto();
      jbdto.setJoinemail(userDto.getJoinemail());
      int jblist = jobCalendarBiz.boardJobListCount(jbdto);
      System.out.println("jblist : " + jblist);

      model.addAttribute("cvlist", cvlist);
      model.addAttribute("pflist", pflist);
      model.addAttribute("jblist", jblist);

      // IT역량 차트
      JSONArray itSkill = totalBiz.selectItSkill(userDto.getJoinemail());
      model.addAttribute("itSkill", itSkill);

      // 스펙 차트
      JSONArray mySkill = totalBiz.selectMySkill(userDto.getJoinemail());
      model.addAttribute("mySkill", mySkill);

      return "USER/userMain";
   }

   // fullCalendar 데이터 불러오기
   @RequestMapping(value = "/USER_getFullCalendarData.do", method = { RequestMethod.POST, RequestMethod.GET })
   @ResponseBody
   public Map<String, List<Map<String, String>>> getFullCalendarData(HttpSession session) {
      logger.info("getFullCalendarData");

      JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

      // 마감일이 수시채용이 아닌 dto 리스트
      List<JobCalendarDto> list = jobCalendarBiz.getFullCalendarData(userDto.getJoinemail());

      // [{title : 'All Day Event', start : '2020-02-01'}]

      List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

      for (JobCalendarDto dto : list) {
         Map<String, String> tem = new HashMap<String, String>();
         String enddate = dto.getEnddate();
         String[] mmdd = enddate.split("/");
         String day = mmdd[1].substring(0, 2);
         enddate = "2020-" + mmdd[0] + "-" + day;

         tem.put("title", dto.getBusiness());
         tem.put("start", enddate);
         tem.put("end", enddate);
         tem.put("companyseq", dto.getCompanyseq() + "");

         dataList.add(tem);
      }

      Map<String, List<Map<String, String>>> res = new HashMap<String, List<Map<String, String>>>();
      res.put("data", dataList);

      return res;
   }

   // 유저 인적사항
   @RequestMapping(value = "/USER_userDetail.do", method = RequestMethod.GET)
   public String userDetail(Model model, HttpSession session) {
      logger.info("userDetail go");

      JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

      TotalDto totalDto = totalBiz.selectOne(userDto.getJoinemail());
      model.addAttribute("totalDto", totalDto);

      // model.addAttribute("totalDto", new TotalDto());

      return "USER/userDetail";
   }

   // 도로명 주소 API
   @RequestMapping(value = "/Address.do")
   public String address() {
      return "USER/userDetail_Address";
   }

   // 인적사항 수정
   @RequestMapping(value = "/USER_detailRes.do", method = RequestMethod.POST)
   public String personal_insert(Model model, @ModelAttribute("totalDto") @Valid TotalDto dto, BindingResult result) {
      
	   if (result.hasErrors()) {	// 유효성검사 에러존재 유무 확인
         logger.info("유효성검사 실패");
         logger.info(dto.getJoinname());
         logger.info(dto.getCertificate());
         logger.info(dto.getRegdate());
         List<ObjectError> list = result.getAllErrors();
         for (ObjectError error : list) {	// 에러 찍어보기
            System.out.println(error);
         }
         return "USER/userDetail";			// 에러메세지 보낼 페이지
      } else {
         logger.info("유효성 검사 통과");
         logger.info(dto.getCertificate());
         logger.info(dto.getRegdate());
         int res = totalBiz.updateOne(dto);
         System.out.println(res);
         if (res > 0) {

            return "redirect:USER_userMain.do";
         } else {
            return "USER/userDetail";
         }
      }
   }

   /*--------------------------------- 이력서 자기소개서 채용공고 게시판 ----------------------------------------------------------------------------------------------------*/
   // 이력서(자기소개서) 게시판
   @RequestMapping(value = "/USER_userCVList.do")
   public String boardListCV(@ModelAttribute("CoverLetterDto") CoverLetterDto dto,
         @RequestParam(defaultValue = "1") int curPage, HttpServletRequest request, Model model,HttpSession session) {
      cvcategory = "자소서";
      JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
      String joinemail = userDto.getJoinemail();
      System.out.println(joinemail);
      dto.setCvcategory(cvcategory);
      dto.setJoinemail(joinemail);

      // 총 게시글 수
      int listCnt = coverletterBiz.boardCVListCount(dto);

      // 페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
      Pagination pagination = new Pagination(listCnt, curPage);
      dto.setStartIndex(pagination.getStartIndex());
      dto.setCntPerPage(pagination.getPageSize() * curPage);

      List<CoverLetterDto> list = coverletterBiz.boardCVList(dto);

      model.addAttribute("boardList", list);
      model.addAttribute("listCnt", listCnt);
      model.addAttribute("pagination", pagination);

      return "USER/userCVdown";
   }


   // 자기소개서 삭제
   @RequestMapping(value = "/USER_userCVdelete.do", method = RequestMethod.POST)
   public String boardCVDelete(@RequestParam(name = "chk") String[] seq) {
      coverletterBiz.CVdelete(seq);
      return "redirect:/USER_userCVList.do";
   }

   
   // 이력서 상세보기
   @RequestMapping(value="USER_userCVDetail.do", method=RequestMethod.GET)
   public String userCVDetail(Model model, String title, HttpSession session) {
	   logger.info("userCVDetail");
	   
	   JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
	   
	   //totalDto -- 아이디
	   TotalDto totalDto = totalBiz.selectOne(userDto.getJoinemail());
	   
	   CoverLetterDto dto = new CoverLetterDto();
	   dto.setJoinemail(userDto.getJoinemail());
	   dto.setTitle(title);
	   
	   //User 이력서 
	   List<CoverLetterDto> CVDto = coverletterBiz.CVselectList(dto);
	   
	   logger.info("확인1 totalDto: =========================>> " + totalDto);
	   logger.info("확인2 CVDto : =========================>> " + CVDto);
	   
	   
	   model.addAttribute("totalDto", totalDto);
	   model.addAttribute("CVDto", CVDto);
	   
	   
	   return "USER/userCVDetail";
   }
   
   // 포트폴리오 게시판
   @RequestMapping(value = "/USER_userPFList.do")
   public String boardListPF(@ModelAttribute("CoverLetterDto") CoverLetterDto dto,
         @RequestParam(defaultValue = "1") int curPage, HttpServletRequest request, Model model , HttpSession session) {
      cvcategory = "포폴";
      JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
      String joinemail = userDto.getJoinemail();
      dto.setCvcategory(cvcategory);
      dto.setJoinemail(joinemail);

      // 총 게시글 수
      int listCnt = coverletterBiz.boardPFListCount(dto);

      // 페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
      Pagination pagination = new Pagination(listCnt, curPage);
      dto.setStartIndex(pagination.getStartIndex());
      dto.setCntPerPage(pagination.getPageSize() * curPage);
      List<CoverLetterDto> list = coverletterBiz.boardPFList(dto);

      model.addAttribute("boardList", list);
      model.addAttribute("listCnt", listCnt);
      model.addAttribute("pagination", pagination);

      return "USER/userPFdown";
   }


   // 포토폴리오 삭제
   @RequestMapping(value = "/USER_userPFdelete.do", method = RequestMethod.POST)
   public String boardPFDelete(@RequestParam(name = "chk") String[] seq) {

      coverletterBiz.PFdelete(seq);

      return "redirect:/USER_userPFList.do";
   }

   // 포토폴리오 상세보기 >>> dto + 작성페이지로
   @RequestMapping(value="/USER_userPFDetail.do", method = RequestMethod.GET)
   public String userPFDetail(Model model, int groupno, HttpSession session, CoverLetterDto dto) {
	   logger.info("userPFwrite");
	   
	   JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
	   
	   dto.setJoinemail(userDto.getJoinemail());
	   dto.setGroupno(groupno);
	   
	   List<CoverLetterDto> coverLetterList = coverletterBiz.PFselectGroupnoList(dto);
	   
	   model.addAttribute("coverLetterList", coverLetterList);
	   return "USER/userPFwrite";
   }
   
   
   
   // 채용즐겨찾기 게시판
   @RequestMapping(value = "/USER_userJobList.do")
   public String BoardJobList(@ModelAttribute("JobCalendarDto") JobCalendarDto jobcalendarDto,
         @RequestParam(defaultValue = "1") int curPage, HttpSession session, Model model) {
      logger.info("JobBoardList");

      JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");

      jobcalendarDto.setJoinemail(userDto.getJoinemail());

      int listCnt = jobCalendarBiz.boardJobListCount(jobcalendarDto);

      // 페이징 (시작글번호, 표시될 게시글) : 연산해서 쿼리문에 사용
      Pagination pagination = new Pagination(listCnt, curPage);
      jobcalendarDto.setStartIndex(pagination.getStartIndex());
      jobcalendarDto.setCntPerPage(pagination.getPageSize() * curPage);
      List<JobCalendarDto> list = jobCalendarBiz.boardJobList(jobcalendarDto);

      model.addAttribute("boardList", list);
      model.addAttribute("listCnt", listCnt);
      model.addAttribute("pagination", pagination);

      return "USER/userJob";
   }

   /*------------------------ 박하 : 자기소개서 작성 --------------------------*/
   // 자기소개서 작성 페이지
   @RequestMapping(value = "/USER_userCVwriteForm.do")
   public String CVWriteForm(Model model) {
       MultiRowTarget targets = new MultiRowTarget();
       model.addAttribute("MultiRowTarget", targets);
      return "USER/userCVwrite";
   }

   // 자기소개서 INSERT
   @RequestMapping(value = "/USER_userCVinsert.do", method = RequestMethod.POST)
   public String CVWriteInsert(Model model, @ModelAttribute("MultiRowTarget") MultiRowTarget targets , HttpSession session) {
      JoinUserDto userDto = (JoinUserDto) session.getAttribute("login");
      String joinemail = userDto.getJoinemail();
      
      int res = 0;
      if (targets.getTargets().size() != 1) {
         for (int i = 0; i < targets.getTargets().size(); i++) {
            // 첫번째 값
            String title = targets.getTargets().get(0).getTitle();
            System.out.println(targets.getTargets().get(i));
            // 나머지 list(dto)에다 설정 set
            targets.getTargets().get(i).setTitle(title);
            targets.getTargets().get(i).setJoinemail(joinemail);
            res = coverletterBiz.CVinsert(targets.getTargets().get(i));
         }
      } else {
         targets.getTargets().get(0).setJoinemail(joinemail);
         res = coverletterBiz.CVinsert(targets.getTargets().get(0));
      }

      if(res > 0) {
         return "redirect:/JOB_jobCenter.do";
         
      } else {
         return "redirect:/MAIN_Main.do";
      }
   }
   /*------------------------ 형권 : 스피치 작성 --------------------------*/
   @RequestMapping(value = "USER_question.do", method = RequestMethod.POST, produces = "application/json; charset=utf8")
   @ResponseBody
   public String question(@RequestBody QnaBoardDto dto) {

      String res = "";

      QnaBoardDto list = qnaboardbiz.boardQnaListOne(dto.getqnaboardseq());

      res = String.valueOf(list.getQuestion());
      return res;
   }

   /*---------------------정답 확인--------------------- */
   @RequestMapping(value = "USER_answer.do", method = RequestMethod.POST)
   @ResponseBody
   public Map<String, String> answer(@RequestBody QnaBoardDto dto) {

      Map<String, String> map = new HashMap<String, String>();

      String result = "";

      int num = dto.getqnaboardseq();

      String userAnswer[] = dto.getAnswer().split(" ");
      QnaBoardDto AnswerDto = qnaboardbiz.QnaAnswer(num);

      String Answer[] = String.valueOf(AnswerDto.getAnswer()).split(" ");
      Arrays.sort(userAnswer);
      Arrays.sort(Answer);

      int answerCnt = 0; // 정답 개수
      int WronganswerCnt = 0; // 오답 개수
      if (userAnswer.length == Answer.length) {

         for (int i = 0; i < Answer.length; i++) {

            if (userAnswer[i].equals(Answer[i])) {
               answerCnt++;
            } else {
               WronganswerCnt++;
            }
         }
         result = (answerCnt == Answer.length ? "정답" : "오답");
      } else {
         result = "오답";
      }
      map.put("result", result);
      map.put("answer", String.valueOf(AnswerDto.getAnswer()));

      return map;
   }
   
   
   
   
   public TotalDto setTotalDto(JoinUserDto dto) {
	   // 가입한 유저정보 불러오기
       JoinUserDto userDto = joinUserBiz.login(dto);

       TotalDto totalDto = new TotalDto();
       
       // 카카오sns 로그인이 현재 값을 제대로 주지 않아서 처리한 로직임.
       if(userDto.getJoinbirth() == null) {
    	   userDto.setJoinbirth("");
       }
       if(userDto.getJoinsex() == null) {
    	   userDto.setJoinsex("");
       }
       totalDto.setJoinseq(userDto.getJoinseq());
       totalDto.setJoinemail(userDto.getJoinemail());
       totalDto.setJoinname(userDto.getJoinname());
       totalDto.setJoinpw(userDto.getJoinpw());
       totalDto.setJoinbirth(userDto.getJoinbirth());
       totalDto.setJoinsex(userDto.getJoinsex());
       totalDto.setPhoto("");
       totalDto.setMililtary("");
       totalDto.setPhone("");
       totalDto.setAddress("");
       totalDto.setKakao("");
       totalDto.setSingup(dto.getSingup());
       // totalDto.setSkillseq(0);
       totalDto.setCategory("");
       totalDto.setItskill1("");
       totalDto.setItskill2("");
       totalDto.setItskill3("");
       totalDto.setItskill4("");
       totalDto.setItskill5("");
       totalDto.setItscore1("");
       totalDto.setItscore2("");
       totalDto.setItscore3("");
       totalDto.setItscore4("");
       totalDto.setItscore5("");
       totalDto.setCertificate("");
       totalDto.setLanguagename("");
       totalDto.setLanguagescore("");
       totalDto.setLanguageregdate("");
       totalDto.setContest("");
       totalDto.setPrize("");
       totalDto.setOrganization("");
       totalDto.setStartorganization("");
       totalDto.setRegdate("");
       // totalDto.setSchoolseq(0);
       totalDto.setCareer("");
       totalDto.setSchoolname("");
       totalDto.setAdmission("");
       totalDto.setGraduate("");
       totalDto.setMajor("");
       totalDto.setGrade("");
       return totalDto;
   }
   
   
}