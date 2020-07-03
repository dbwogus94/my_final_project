package com.job.coverletter.model.total.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.job.coverletter.model.skill.dto.SkillDto;
import com.job.coverletter.model.total.dto.TotalDto;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Repository
public class TotalDaoImpl implements TotalDao {

	@Autowired
	@Qualifier("sqlSessionTemPlate")
	private SqlSessionTemplate sqlSession;

	// 로그인
	//private String login = "cv@email.com";

	@Override
	public int ToTalInsert(TotalDto dto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "ToTalInsert", dto);
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public TotalDto selectOne(String joinemail) {
		return sqlSession.selectOne(NAMESPACE + "selectOne", joinemail);
	}

	@Override
	public int updateOne(TotalDto dto) {
		return sqlSession.update(NAMESPACE + "updateOne", dto);
	}

	/*-------------------------스킬차트-----------------------------*/
	@Override
	public JSONArray selectItSkill(String joinemail) {
		TotalDto dto = new TotalDto();
		dto.setJoinemail(joinemail);

		List<Map<String, String>> list = null;
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectItSkill", dto);

			for (Map<String, String> map : list) {
				obj.put("skill1", map.get("ITSKILL1"));
				obj.put("skill2", map.get("ITSKILL2"));
				obj.put("skill3", map.get("ITSKILL3"));
				obj.put("skill4", map.get("ITSKILL4"));
				obj.put("skill5", map.get("ITSKILL5"));
				obj.put("score1", map.get("ITSCORE1"));
				obj.put("score2", map.get("ITSCORE2"));
				obj.put("score3", map.get("ITSCORE3"));
				obj.put("score4", map.get("ITSCORE4"));
				obj.put("score5", map.get("ITSCORE5"));
				if (obj != null) {
					arr.add(obj);
				}
			}

		} catch (Exception e) {
			System.out.println("[error] : selectItSkill");
			e.printStackTrace();
		}

		return arr;
	}

	@Override
	public JSONArray selectMySkill(String joinemail) {
		TotalDto dto = new TotalDto();
		dto.setJoinemail(joinemail);

		List<TotalDto> list = null;
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();

		try {
			list = sqlSession.selectList(NAMESPACE + "selectMySkill", dto);
			for (TotalDto data : list) {
				String[] language = data.getLanguagescore().split(",", -1);
				System.out.println(language[0]);
				
				String[] contest = {"0"};
				if (data.getContest() != null) {
					contest = data.getContest().split(",", -1);
				}
				System.out.println(contest[0]);
				
				String[] certificate = {"0"};
				if(data.getCertificate() != null) {
					certificate = data.getCertificate().split(",", -1);
				}
				System.out.println(certificate[0]);
				String grade = Integer.toString((int) Math.round((100 * Double.parseDouble(data.getGrade())) / 4.5));
				System.out.println("학점 : "+grade);
				String[] career = data.getCareer().split(",", -1);
				int careerRes = 0;
				switch (career[0]) {
				case "대졸":
					careerRes = 100;
					break;
				case "초대졸":
					careerRes = 80;
					break;
				case "고졸":
					careerRes = 60;
					break;
				default:
					careerRes = 40;
					break;
				}

				obj.put("어학", Integer.parseInt(language[0])/10);
				obj.put("공모전", contest.length);
				obj.put("자격증", certificate.length);
				obj.put("학점", grade);
				obj.put("학력", careerRes);

				if (obj != null) {
					arr.add(obj);
					System.out.println(arr);
				}
			}

		} catch (Exception e) {
			System.out.println("[error] : selectMySkill");
			e.printStackTrace();
		}

		return arr;

	}






}
