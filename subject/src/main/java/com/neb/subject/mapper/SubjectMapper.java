package com.neb.subject.mapper;

import com.neb.subject.api.SubjectRequestDto;
import com.neb.subject.api.SubjectResponseDto;
import com.neb.subject.entities.SubjectEntity;

public interface SubjectMapper {

    SubjectResponseDto entityToDto(SubjectEntity entity);

    SubjectEntity dtoToEntity(SubjectRequestDto dto);
}
