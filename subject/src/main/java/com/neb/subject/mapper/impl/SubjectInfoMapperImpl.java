package com.neb.subject.mapper.impl;

import com.neb.subject.api.request.SubjectInfoRequestDto;
import com.neb.subject.api.response.SubjectInfoResponseDto;
import com.neb.subject.entities.SubjectEntity;
import com.neb.subject.entities.SubjectInfoEntity;
import com.neb.subject.mapper.SubjectInfoMapper;
import com.neb.subject.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubjectInfoMapperImpl implements SubjectInfoMapper {

    private final ModelMapper modelMapper;
    private final SubjectRepository subjectRepository;

    @Override
    public SubjectInfoResponseDto entityToDto(SubjectInfoEntity entity) {

        SubjectInfoResponseDto responseDto = new SubjectInfoResponseDto();

        modelMapper.map(entity, responseDto);
        responseDto.setSubjectId(entity.getSubjectEntity().getId());

        return responseDto;
    }

    @Override
    public SubjectInfoEntity dtoToEntity(SubjectInfoRequestDto dto) {

        SubjectInfoEntity entity = new SubjectInfoEntity();
        SubjectEntity associatedSubject = subjectRepository.getById(dto.getSubjectId());

        modelMapper.map(dto, entity);

        entity.setSubjectEntity(associatedSubject);

        return entity;
    }
}
