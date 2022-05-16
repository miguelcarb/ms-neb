package com.neb.student.service;

import com.neb.student.api.StudentRequestDto;
import com.neb.student.api.StudentResponseDto;
import com.neb.student.entities.StudentEntity;
import com.neb.student.entities.StudentSubjectEntity;
import com.neb.student.entities.SubjectEntity;
import com.neb.student.repository.StudentRepository;
import com.neb.student.repository.StudentSubjectRepository;
import com.neb.student.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import message.MessageClient;
import message.MessageRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentSubjectRepository studentSubjectRepository;

    private final SubjectRepository subjectRepository;

    private final MessageClient messageClient;

    @Transactional
    public void registerStudent(StudentRequestDto request) {

        StudentEntity student = new StudentEntity();

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setDegree(request.getDegree());

        studentRepository.save(student);

        request.getSubjectIds().forEach(id -> {

            SubjectEntity subject = subjectRepository.getById(id);

            if (!ObjectUtils.isEmpty(subject)) {
                StudentSubjectEntity studentSubjectEntity = new StudentSubjectEntity();

                studentSubjectEntity.setStudentId(student.getId());
                studentSubjectEntity.setSubjectId(id);

                studentSubjectRepository.save(studentSubjectEntity);
            } else {
                log.debug("Subject with id: {}", id + " does not exist");
            }

        });

        registeredStudentNotification(request);
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

        List<StudentSubjectEntity> studentSubjectEntities = studentSubjectRepository.findAllByStudentId(id);

        List<String> studentSubjects = studentSubjectEntities.stream().map(sbe -> subjectRepository
                .getById(sbe.getSubjectId())
                .getTitle())
                .collect(Collectors.toList());

        StudentResponseDto response = StudentResponseDto.builder()
                .id(id)
                .firstName(studentEntity.getFirstName())
                .lastName(studentEntity.getLastName())
                .email(studentEntity.getEmail())
                .degree(studentEntity.getDegree())
                .subjects(studentSubjects)
                .build();

        return response;
    }

    @Transactional
    public void deleteStudentById(Long id) {

        StudentEntity studentEntity = studentRepository.getById(id);

        studentRepository.delete(studentEntity);
    }

    private void registeredStudentNotification(StudentRequestDto requestDto) {

        MessageRequestDto messageRequestDto = new MessageRequestDto();

        messageRequestDto.setEmail(requestDto.getEmail());
        messageRequestDto.setContent("New student registered");

        messageClient.saveMessage(messageRequestDto);
    }
}
