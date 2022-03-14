package com.neb.student.crud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public void registerStudent(StudentRequestDto request) {

        StudentEntity student = new StudentEntity();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setDegree(request.getDegree());

        studentRepository.save(student);
    }

    @Transactional
    public StudentResponseDto updateStudentById(Long id, StudentRequestDto request) {

        StudentEntity studentEntity = studentRepository.getById(id);

        studentEntity.setFirstName(request.getFirstName());
        studentEntity.setLastName(request.getLastName());
        studentEntity.setEmail(request.getEmail());
        studentEntity.setDegree(request.getDegree());

        StudentResponseDto response = StudentResponseDto.builder()
                .id(id)
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .email(studentEntity.getEmail())
                .degree(studentEntity.getDegree())
                .build();

        return response;
    }

    @Transactional
    public StudentResponseDto findStudentById(Long id) {

        StudentEntity studentEntity = studentRepository.getById(id);

        StudentResponseDto response = StudentResponseDto.builder()
                .id(id)
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .email(studentEntity.getEmail())
                .degree(studentEntity.getDegree())
                .build();

        return response;
    }

    @Transactional
    public void deleteStudentById(Long id) {

        StudentEntity studentEntity = studentRepository.getById(id);

        studentRepository.delete(studentEntity);
    }
}
