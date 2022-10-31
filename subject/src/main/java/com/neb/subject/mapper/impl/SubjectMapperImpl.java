package com.neb.subject.mapper.impl;

import com.neb.subject.api.SubjectRequestDto;
import com.neb.subject.api.SubjectResponseDto;
import com.neb.subject.entities.SubjectEntity;
import com.neb.subject.mapper.SubjectMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubjectMapperImpl implements SubjectMapper {

    private final ModelMapper modelMapper;

    @Override
    public SubjectResponseDto entityToDto(SubjectEntity entity) {

        SubjectResponseDto responseDto = new SubjectResponseDto();

        modelMapper.map(entity, responseDto);

        return responseDto;
    }

    @Override
    public SubjectEntity dtoToEntity(SubjectRequestDto dto) {

        SubjectEntity entity = new SubjectEntity();

        modelMapper.map(dto, entity);

        return entity;
    }
}
