package com.ohgiraffers.proj240315.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ohgiraffers.proj240315")
@MapperScan(
		basePackages = "com.ohgiraffers.proj240315",
		annotationClass = Mapper.class
)
public class CrudProj240315Application {

	public static void main(String[] args) {

		SpringApplication.run(CrudProj240315Application.class, args);
	}

}
