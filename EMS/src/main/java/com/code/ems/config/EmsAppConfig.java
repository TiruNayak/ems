package com.code.ems.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.code.ems")
@PropertySource(value = { "classpath:db-mysql.properties"})
public class EmsAppConfig {


    @Autowired
    private Environment env;
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	 @Bean
	 public DataSource getDataSource() {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	     dataSource.setUrl("jdbc:mysql://localhost:3306/ems_db?useSSL=false&requireSSL=false");
	     dataSource.setUsername("root");
         dataSource.setPassword("root");
	         
	     return dataSource;
	 }
	 
	 @Bean
	 public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	     jdbcTemplate.setResultsMapCaseInsensitive(true);
	     
	     return jdbcTemplate;
		 
	 }
}
