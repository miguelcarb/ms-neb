package com.neb.student.repository;

import com.neb.student.entities.StudentSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubjectEntity, Long> {

    public List<StudentSubjectEntity> findAllByStudentId(Long id);
}
