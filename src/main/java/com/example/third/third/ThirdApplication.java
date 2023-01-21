package com.example.third.third;

import com.example.third.third.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication

public class ThirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdApplication.class, args);
	}






}
