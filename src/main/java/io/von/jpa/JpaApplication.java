package io.von.jpa;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages= {"io.von.jpa"})
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	
	  @Bean 
	  public DataSource getDataSource(){ 
			
			  return DataSourceBuilder.create()
			  .url("jdbc:oracle:thin:@localhost:1521/orcl").username("springboot").password(
			  "springboot") .build();
			 
	     
	  }
	 
}
