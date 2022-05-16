package com.neb.subject.controller;

import com.neb.subject.api.SubjectRequestDto;
import com.neb.subject.api.SubjectResponseDto;
import com.neb.subject.service.SubjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/subject")
@AllArgsConstructor
public class SubjectController {

    private final SubjectService service;

    @PostMapping(value ="/addSubject")
    public ResponseEntity<Void> addSubject(@RequestBody SubjectRequestDto requestDto) {

        log.info("Entering subject registration {}, subject: ", requestDto);

        service.addSubject(requestDto);

        return ResponseEntity.noContent().header("Location", requestDto.getCode()).build();
    }

    @PutMapping(value ="/updateSubject/{id}")
    public ResponseEntity<SubjectResponseDto> updateSubjectById(
            @PathVariable(value = "id") Long id,
            @RequestBody SubjectRequestDto requestDto) {

        log.debug("Entering updateSubjectById [id]: {}", id);

        SubjectResponseDto responseDto = service.updateSubjectById(id, requestDto);

        log.debug("Leaving updateSubjectById [id]: {}", id);

        return ResponseEntity.ok().body(responseDto);
    }

    @GetMapping(value ="/findSubject/{id}")
    public ResponseEntity<SubjectResponseDto> findSubjectById(@PathVariable(value = "id") Long id) {

        log.debug("Entering findSubjectById [id]: {}", id);

        SubjectResponseDto responseDto = service.findSubjectById(id);

        log.debug("Leaving findSubjectById [id]: {}", id);

        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping(value ="/deleteSubject/{id}")
    public ResponseEntity<Void> deleteSubjectById(@PathVariable(value = "id") Long id) {

        log.info("Entering delete subject by Id {}: ", id);

        service.deleteSubjectById(id);

        return ResponseEntity.ok().build();
    }
}
