package com.code.ems.dao;

import java.util.List;



import com.code.ems.model.Skill;

public interface SkillDao {

	
	
	public Skill getSkill(int skillId);
	public List<Skill> getSkills(int empId);
	public int addSkill(Skill skill);
}
