package com.example.third.third.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {


        return args -> {
            Student mariam = new Student("Mari", LocalDate.of(1986, 8, 19), "232435@gmail.com" );
            Student alex = new Student("Alex", LocalDate.of(2000, 8, 21), "Alex@gmail.com" );


            List<Student> students= List.of(mariam, alex);
            repository.saveAll(students);

        };

    }
}
