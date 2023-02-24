package com.neb.subject.repository;

import com.neb.subject.entities.SubjectInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectInfoRepository extends JpaRepository<SubjectInfoEntity, Long> {

    List<SubjectInfoEntity> findBySubjectEntityId(Long subjectId);
}
