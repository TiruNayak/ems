package com.code.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.ems.dao.SkillDao;
import com.code.ems.model.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillDao skillDao;
	
	public void addSkills(List<Skill> skills) {
		for(Skill skill:skills) {
			skillDao.addSkill(skill);
		}

	}

}
