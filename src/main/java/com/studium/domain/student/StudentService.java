package com.studium.domain.student;

import com.studium.domain.student.dto.StudentCreateDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student create(@Valid StudentCreateDTO dto) {
        Student student = new Student(dto);
        String sid = student.generateSid(dto.modality());
        student.setSid(sid);
        student = studentRepository.save(student);
        return student;
    }
}
