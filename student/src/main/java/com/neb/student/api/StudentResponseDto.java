package com.neb.student.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String degree;

    private List<String> subjects;
}
