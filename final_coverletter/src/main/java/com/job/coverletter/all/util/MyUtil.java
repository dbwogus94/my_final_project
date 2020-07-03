package com.job.coverletter.all.util;

import java.util.List;

import com.job.coverletter.model.company.dto.CompanyDto;

public class MyUtil {

	
	public static String StringCut(int textLen, String text) {
			String res = "";
			if(text.length() >= textLen) {
				res += text.substring(0, textLen) + "...";
				return res;
			} else {
				return text;
			}
	}

	
}
