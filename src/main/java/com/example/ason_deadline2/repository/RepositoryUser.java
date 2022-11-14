package com.example.ason_deadline2.repository;

import com.example.ason_deadline2.model.entityUser.EntityUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<EntityUser, Integer> {
    EntityUser getById(Integer Id);

    Page<EntityUser> findAll(Pageable pageable);


}
