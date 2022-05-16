package com.neb.subject.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@EqualsAndHashCode()
@ToString(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long id;

    @Column(name = "subject_code", length = 20)
    private String code;

    @Column(name = "subject_title", length = 50)
    private String title;

    @Column(name = "subject_credits")
    private Integer credits;

}
