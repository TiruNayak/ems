package com.code.ems.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Skill {

	@NotNull
	@Min(1)
	private int id;
	
	@NotNull(message="skill cannot be null")
	@Size(min=1,max=30)
	private String skill;
	
	
	public Skill() {}


	public Skill(int id, String skill) {
		this.id = id;
		this.skill = skill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}


	@Override
	public String toString() {
		return "Skill [id=" + id + ", skill=" + skill + "]";
	}

	
}
