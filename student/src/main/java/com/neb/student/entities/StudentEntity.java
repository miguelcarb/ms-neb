package com.neb.student.entities;

import com.neb.student.entities.PersonEntity;
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
@Table(name = "student")
public class StudentEntity extends PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long id;

    @Column(name = "current_degree", nullable = false, length = 50)
    private String degree;

}
