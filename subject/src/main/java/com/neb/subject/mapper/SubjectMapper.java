package com.neb.subject.mapper;

import com.neb.subject.api.request.SubjectRequestDto;
import com.neb.subject.api.response.SubjectResponseDto;
import com.neb.subject.entities.SubjectEntity;

public interface SubjectMapper {

    SubjectResponseDto entityToDto(SubjectEntity entity);

    SubjectEntity dtoToEntity(SubjectRequestDto dto);
}
