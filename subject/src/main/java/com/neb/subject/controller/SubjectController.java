package com.neb.subject.controller;

import com.neb.subject.api.request.SubjectFilterRequestDto;
import com.neb.subject.api.request.SubjectRequestDto;
import com.neb.subject.api.response.SliceCriteriaResponseDto;
import com.neb.subject.api.response.SubjectResponseDto;
import com.neb.subject.service.SubjectService;
import io.swagger.annotations.ApiParam;
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

    @GetMapping(value = "/criteria")
    public ResponseEntity<SliceCriteriaResponseDto> findSubjectByCriteria(
        @ApiParam(name = "code", value = "code of the subject")
        @RequestParam(required = false, name = "code")
        String code,
        @ApiParam(name = "title", value = "title of the subject")
        @RequestParam(required = false, name = "title")
        String title,
        @ApiParam(name = "pageSize", value = "number of elements to be returned", example = "10")
        @RequestParam(value = "pageSize", required = false, defaultValue = "10")
        Integer pageSize,
        @ApiParam(name = "offset", value = "index from which the result must be fetched", example = "0")
        @RequestParam(value = "offset", required = false, defaultValue = "0")
        Integer offset
    ) {
        log.debug("Entering findSubjectByCriteria");

        SubjectFilterRequestDto criteria = SubjectFilterRequestDto
                .builder()
                .code(code)
                .title(title)
                .pageSize(pageSize)
                .offset(offset)
                .build();

        SliceCriteriaResponseDto responseDto = service.findSubjectByCriteria(criteria);

        log.debug("Leaving findSubjectByCriteria [response]: {}", responseDto);

        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping(value ="/deleteSubject/{id}")
    public ResponseEntity<Void> deleteSubjectById(@PathVariable(value = "id") Long id) {

        log.info("Entering delete subject by Id {}: ", id);

        service.deleteSubjectById(id);

        return ResponseEntity.ok().build();
    }
}
