package com.studium.controller;

import com.studium.domain.student.Student;
import com.studium.domain.student.StudentService;
import com.studium.domain.student.dto.StudentCreateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> create (@RequestBody @Valid StudentCreateDTO dto){
        Student student = studentService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

}
