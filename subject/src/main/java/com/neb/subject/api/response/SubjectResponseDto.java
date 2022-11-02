package com.neb.subject.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectResponseDto implements Serializable {

    private Long id;

    private String code;

    private String title;

    private Integer credits;
}
