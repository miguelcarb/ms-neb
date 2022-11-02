package com.neb.subject.repository;

import com.neb.subject.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long>, JpaSpecificationExecutor<SubjectEntity> {
}
