package com.neb.student.crud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequestDto implements Serializable {

    private String firstName;

    private String lastName;

    private String email;

    private String degree;
}
