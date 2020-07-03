package com.job.coverletter.model.joinUser.biz;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.coverletter.all.TestException;
import com.job.coverletter.model.joinUser.dao.JoinUserDao;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;

@Service
public class JoinUserBizImpl implements JoinUserBiz {
	@Autowired
	private JoinUserDao joinuserdao;

	@Override
	public int insertUser(JoinUserDto joinuser) {
		return joinuserdao.insertUser(joinuser);
	}

	@Override
	public JoinUserDto selectOne(String joinemail) {

		return joinuserdao.selectOne(joinemail);
	}

	@Override
	public int updateJoinuser(JoinUserDto dto) {

		return joinuserdao.updateJoinuser(dto);
	}

	@Override
	public int deletejoinuser(String joinemail) {

		return joinuserdao.deletejoinuser(joinemail);
	}

	
	@Override
	public JoinUserDto login(JoinUserDto dto) {
		
		return joinuserdao.login(dto);
	}

	@Override
	public String checkemail(String joinemail) {
		return joinuserdao.checkemail(joinemail);
	}

	@Override
	public JoinUserDto kakaoLogin(JoinUserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public JoinUserDto kakaoLogin(JoinUserDto dto) {
//		
////		if(joinemail != joinemail) {
////			return joinuserdao.kakaoLogin(dto);
////		}else if
////		
//		
//		return joinuserdao.kakaoLogin(dto);
//	}

}
