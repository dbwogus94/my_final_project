package com.job.coverletter.model.coverletter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

@Repository
public class CoverLetterDaoImpl implements CoverLetterDao {

	@Autowired
	@Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	// 유저에 따른 자기소개서 총 게시글 수
	@Override
	public int boardCVListCount(CoverLetterDto dto) {
		return sqlSession.selectOne(NAMESPACE + "boardCVListCount", dto);
	}

	// 유저에 따른 자기소개서 글목록(+페이징) select
	@Override
	public List<CoverLetterDto> boardCVList(CoverLetterDto dto) {
		return sqlSession.selectList(NAMESPACE + "boardCVList", dto);
	}

	// 자기소개서 INSERT
	@Override
	public int CVinsert(CoverLetterDto dto) {
		return sqlSession.insert(NAMESPACE + "CVinsert", dto);
	}

	// 자기소개서 title기준으로 목록 select
	@Override
	public List<CoverLetterDto> CVselectList(CoverLetterDto dto) {
		return sqlSession.selectList(NAMESPACE + "CVselectList", dto);
	}

	// 자기소개서 delete(멀티삭제)
	@Override
	public int CVdelete(String[] seq) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seq);
		return sqlSession.delete(NAMESPACE + "CVmuldel", map);
	}

	
//========================= 포토폴리오 메서드 시작 ==============================	
	
	
	
	// 유저에 따른 포토폴리오 총 개수 가져오기
	@Override
	public int boardPFListCount(CoverLetterDto dto) {
		return sqlSession.selectOne(NAMESPACE + "boardPFListCount", dto);
	}

	// 유저에 따른 포토폴리오 게시글 전체 목록(+페이징) select
	@Override
	public List<CoverLetterDto> boardPFList(CoverLetterDto dto) {
		return sqlSession.selectList(NAMESPACE + "boardPFList", dto);
	}

	// 포토폴리오 그룹번호 가져오기
	@Override
	public CoverLetterDto getGroupno(String joinemail) {
		CoverLetterDto dto = new CoverLetterDto();
		int res = 0;
		if (sqlSession.selectOne(NAMESPACE + "getGroupno", joinemail) != null) {
			res = sqlSession.selectOne(NAMESPACE + "getGroupno", joinemail);
			dto.setGroupno(res);
			return dto;
		} else {
			dto.setGroupno(res);
			return dto;
		}
	}

	// 포토폴리오 insert
	@Override
	public int PFwrite(CoverLetterDto dto) {
		return sqlSession.insert(NAMESPACE + "PFinsert", dto);
	}

	// 포토폴리오 그룹번호를 기준으로 리스트로 가져오기
	@Override
	public List<CoverLetterDto> PFselectGroupnoList(CoverLetterDto dto) {
		return sqlSession.selectList(NAMESPACE + "PFDetail", dto);
	}

	// 포토폴리오 delete(멀티삭제)
	@Override
	public int PFdelete(String[] seq) {
		int res = 0;
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seq);
			res = sqlSession.delete(NAMESPACE + "PFmuldel", map);
		return res;
	}

}
