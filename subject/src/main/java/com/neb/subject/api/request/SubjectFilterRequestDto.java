package com.neb.subject.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectFilterRequestDto {

    private String code;

    private String title;

    private Integer offset;

    private Integer pageSize;

}
