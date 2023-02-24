package com.neb.subject.mapper.impl;

import com.neb.subject.api.request.SubjectRequestDto;
import com.neb.subject.api.response.SubjectResponseDto;
import com.neb.subject.entities.SubjectEntity;
import com.neb.subject.mapper.SubjectInfoMapper;
import com.neb.subject.mapper.SubjectMapper;
import com.neb.subject.repository.SubjectInfoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SubjectMapperImpl implements SubjectMapper {

    private final ModelMapper modelMapper;
    private final SubjectInfoMapper subjectInfoMapper;
    private final SubjectInfoRepository subjectInfoRepository;

    @Override
    public SubjectResponseDto entityToDto(SubjectEntity entity) {

        SubjectResponseDto responseDto = new SubjectResponseDto();

        modelMapper.map(entity, responseDto);
        responseDto.setSubjectMultilingualDescriptions(subjectInfoRepository.findBySubjectEntityId(entity.getId())
                .stream().map(subjectInfoMapper::entityToDto)
                .collect(Collectors.toList()));

        return responseDto;
    }

    @Override
    public SubjectEntity dtoToEntity(SubjectRequestDto dto) {

        SubjectEntity entity = new SubjectEntity();

        modelMapper.map(dto, entity);

        return entity;
    }
}
