package com.job.coverletter.all.util;

import java.lang.annotation.Target;
import java.util.List;

import com.job.coverletter.model.coverletter.dto.CoverLetterDto;

public class MultiRowTarget {
	
	private List<CoverLetterDto> targets;
	
	public MultiRowTarget(List<CoverLetterDto> targets) {
		super();
		this.targets = targets;
	}

	public MultiRowTarget() {
	}

	public List<CoverLetterDto> getTargets() {
		return targets;
	}

	public void setTargets(List<CoverLetterDto> targets) {
		this.targets = targets;
	}
	
	@Override
	public String toString() {
		return "MultiRowTarget [targets=" + targets + "]";
	}
	
	
}
