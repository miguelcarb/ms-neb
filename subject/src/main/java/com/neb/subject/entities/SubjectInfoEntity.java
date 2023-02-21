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
@Table(name = "info_subject")
public class SubjectInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_code")
    private SubjectEntity subjectEntity;

    @Column(name = "description")
    private String description;

    @Column(name = "code_language")
    private String language;
}
