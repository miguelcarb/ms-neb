package com.neb.subject.service;

import com.neb.subject.api.request.SubjectFilterRequestDto;
import com.neb.subject.api.request.SubjectRequestDto;
import com.neb.subject.api.response.SliceCriteriaResponseDto;
import com.neb.subject.api.response.SubjectResponseDto;
import com.neb.subject.entities.SubjectEntity;
import com.neb.subject.mapper.SubjectMapper;
import com.neb.subject.repository.SubjectRepository;
import com.neb.subject.repository.spec.SubjectSpecifications;
import com.neb.subject.utils.SliceUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class SubjectService {

    private final SubjectRepository repository;
    private final SubjectMapper subjectMapper;

    @Transactional
    public void addSubject(SubjectRequestDto requestDto) {

        SubjectEntity subject = subjectMapper.dtoToEntity(requestDto);;

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

    @Transactional(readOnly = true)
    public SliceCriteriaResponseDto findSubjectByCriteria(SubjectFilterRequestDto filters) {

        Pageable pageable = PageRequest
                .of(filters.getOffset(), filters.getPageSize(), Sort.by(Sort.Direction.ASC, "code"));

        Page<SubjectEntity> page = repository.findAll(
                SubjectSpecifications.likeCode(Optional.ofNullable(filters.getCode()))
                        .and(SubjectSpecifications.likeTitle(Optional.ofNullable(filters.getTitle()))),
                pageable
        );

        List<SubjectEntity> subjectResponse = (List<SubjectEntity>) SliceUtils
                .sliceCriteriaResponseDto(filters.getOffset(), filters.getPageSize(), page)
                .getResults();
        SliceCriteriaResponseDto responseDto = SliceUtils
                .sliceCriteriaResponseDto(filters.getOffset(), filters.getPageSize(), page);
        responseDto.setResults(subjectResponse.stream().map(subjectMapper::entityToDto).collect(Collectors.toList()));

        return responseDto;

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
