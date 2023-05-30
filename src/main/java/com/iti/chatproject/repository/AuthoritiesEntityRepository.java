package com.iti.chatproject.repository;

import com.iti.chatproject.entity.AuthoritiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesEntityRepository extends JpaRepository<AuthoritiesEntity, String> {
}
