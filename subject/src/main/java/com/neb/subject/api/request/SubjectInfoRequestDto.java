package com.neb.subject.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectInfoRequestDto {

    private Long subjectId;

    private String description;

    private String language;
}
