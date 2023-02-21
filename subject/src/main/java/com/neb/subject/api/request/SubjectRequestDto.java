package com.neb.subject.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectRequestDto implements Serializable {

    private String code;

    private String title;

    private Integer credits;

    private List<SubjectInfoRequestDto> subjectMultilingualDescriptions;
}
