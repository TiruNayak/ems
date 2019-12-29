package com.code.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.code.ems.model.Skill;

@Repository
public class SkillDaoImpl implements SkillDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	String empSkills = "select * from emp_skill where emp_id = ?";
	
	public Skill getSkill(int skillId) {
		
		return null;
	}

	public List<Skill> getSkills(int empId) {
		return jdbcTemplate.query(empSkills, 
									new Object[] {empId}, 
									new SkillMapper());
	}

	public int addSkill(Skill skill) {
		
		return 0;
	}
	
	private static final class SkillMapper implements RowMapper<Skill>{

		public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
			Skill skill = new Skill();
			skill.setId(rs.getInt("id"));
			skill.setSkill(rs.getString("skill"));
			
			return skill;
		}
		
	}

}
