package com.neb.student.api;

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
public class StudentRequestDto implements Serializable {

    private String firstName;

    private String lastName;

    private String email;

    private String degree;

    private List<Long> subjectIds;

}
