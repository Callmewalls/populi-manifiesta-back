package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.OrganizerEntity;

@Repository
public interface OrganizerRepository extends JpaRepository<OrganizerEntity, Long> {
    // Puedes agregar consultas personalizadas si necesitas
}
