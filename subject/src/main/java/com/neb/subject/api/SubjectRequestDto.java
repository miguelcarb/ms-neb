package com.neb.subject.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectRequestDto implements Serializable {

    private String code;

    private String title;

    private Integer credits;
}
