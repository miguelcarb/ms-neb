package com.neb.subject.service;

import com.neb.subject.api.SubjectRequestDto;
import com.neb.subject.api.SubjectResponseDto;
import com.neb.subject.entities.SubjectEntity;
import com.neb.subject.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
@AllArgsConstructor
public class SubjectService {

    private final SubjectRepository repository;

    @Transactional
    public void addSubject(SubjectRequestDto requestDto) {

        SubjectEntity subject = new SubjectEntity();

        subject.setCode(requestDto.getCode());
        subject.setTitle(requestDto.getTitle());
        subject.setCredits(requestDto.getCredits());

        repository.save(subject);
    }

    @Transactional
    public SubjectResponseDto updateSubjectById(Long id, SubjectRequestDto requestDto) {

        SubjectEntity subjectEntity = repository.getById(id);

        subjectEntity.setCode(requestDto.getCode());
        subjectEntity.setCredits(requestDto.getCredits());
        subjectEntity.setTitle(requestDto.getTitle());

        SubjectResponseDto subjectResponseDto = SubjectResponseDto.builder()
                .id(id)
                .code(subjectEntity.getCode())
                .credits(subjectEntity.getCredits())
                .title(subjectEntity.getTitle())
                .build();

        return subjectResponseDto;
    }

    @Transactional(readOnly = true)
    public SubjectResponseDto findSubjectById(Long id) {

        SubjectEntity subjectEntity = repository.getById(id);

        SubjectResponseDto subjectResponseDto = SubjectResponseDto.builder()
                .id(id)
                .code(subjectEntity.getCode())
                .credits(subjectEntity.getCredits())
                .title(subjectEntity.getTitle())
                .build();

        return subjectResponseDto;
    }

    @Transactional
    public void deleteSubjectById(Long id) {

        SubjectEntity subject = repository.getById(id);

        if (checkIfSubjectExistsById(id)) {
           log.debug("Subject with id: {} ", id + " does not exist");
        }

        repository.delete(subject);
    }

    @Transactional
    public boolean checkIfSubjectExistsById(Long id) {

        SubjectEntity subject = repository.getById(id);

        return ObjectUtils.isEmpty(subject);
    }
}
