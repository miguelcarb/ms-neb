package com.neb.subject.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SliceCriteriaResponseDto {

    private Integer totalPages;

    private Integer pageSize;

    private Integer offset;

    private Long totalRecords;

    List<?> results = new ArrayList<>();

}
