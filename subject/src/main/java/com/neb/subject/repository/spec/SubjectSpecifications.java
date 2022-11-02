package com.neb.subject.repository.spec;

import com.neb.subject.entities.SubjectEntity;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public class SubjectSpecifications {

    public static Specification<SubjectEntity> likeCode(Optional<String> code) {

        return (root, query, builder) -> {
            return code.map(codSubject -> {
                return builder.like(builder.upper(root.get("code")), "%" + codSubject.toUpperCase() + "%");
            }).orElse(null);
        };
    }

    public static Specification<SubjectEntity> likeTitle(Optional<String> title) {

        return (root, query, builder) -> {
            return title.map(titleSubject -> {
                return builder.like(builder.upper(root.get("title")), "%" + titleSubject.toUpperCase() + "%");
            }).orElse(null);
        };
    }
}
