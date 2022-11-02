package com.neb.subject.utils;

import com.neb.subject.api.response.SliceCriteriaResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.util.ObjectUtils;

public class SliceUtils {

    /**
     * method used to return any paged list of objects
     *
     * @param offset
     * @param pageSize
     * @param page
     * @return
     */
    public static SliceCriteriaResponseDto sliceCriteriaResponseDto(Integer offset, Integer pageSize, Page page) {

        SliceCriteriaResponseDto responseDto = new SliceCriteriaResponseDto();

        if(!ObjectUtils.isEmpty(page)) {
            responseDto.setOffset(offset);
            responseDto.setPageSize(pageSize);
            responseDto.setTotalPages(page.getTotalPages());
            responseDto.setTotalRecords(page.getTotalElements());
            responseDto.setResults(page.toList());
        }

        return responseDto;

    }
}
