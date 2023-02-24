package com.neb.subject.mapper;

import com.neb.subject.api.request.SubjectInfoRequestDto;
import com.neb.subject.api.response.SubjectInfoResponseDto;
import com.neb.subject.entities.SubjectInfoEntity;

public interface SubjectInfoMapper {

    SubjectInfoResponseDto entityToDto(SubjectInfoEntity entity);

    SubjectInfoEntity dtoToEntity(SubjectInfoRequestDto dto);
}
