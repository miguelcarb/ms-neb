package com.neb.student.crud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Void> registerStudent(@RequestBody StudentRequestDto studentRequestDto) {
        log.info("Entering student registration {}, student: ", studentRequestDto);

        studentService.registerStudent(studentRequestDto);

        return ResponseEntity.noContent().build(); // header can be added
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<StudentResponseDto> updateStudentById(@PathVariable(value = "id") Long id, @RequestBody StudentRequestDto studentRequestDto) {
        log.info("Entering update student by Id {}, student, id: ", studentRequestDto + ", " + id);

        Optional<StudentResponseDto> responseDto = Optional.of(studentService.updateStudentById(id, studentRequestDto));

        return ResponseEntity.of(responseDto);
    }

    @GetMapping("/findStudent/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable(value = "id") Long id) {
        log.info("Entering find student by Id {}: ", id);

        Optional<StudentResponseDto> responseDto = Optional.of(studentService.findStudentById(id));

        return ResponseEntity.of(responseDto);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable(value = "id") Long id) {
        log.info("Entering delete student by Id {}: ", id);

        studentService.deleteStudentById(id);

        return ResponseEntity.ok().build();
    }
}
