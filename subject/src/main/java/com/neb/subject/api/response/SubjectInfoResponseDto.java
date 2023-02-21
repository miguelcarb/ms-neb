package com.neb.subject.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectInfoResponseDto {

    private Long id;

    private String subjectCode;

    private String description;

    private String language;

}
