package com.example.third.third.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    @Query("Select s from Student s Where s.email = ?1")
    Student findStudentByEmail (String email) ;

    Student findStudentById (Long id) ;
}
