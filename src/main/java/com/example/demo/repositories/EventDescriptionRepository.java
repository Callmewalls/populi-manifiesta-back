package com.example.demo.repositories;

import com.example.demo.entities.DayDescriptionEntity;
import com.example.demo.entities.EventDescriptionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventDescriptionRepository extends JpaRepository<EventDescriptionEntity, Long>, JpaSpecificationExecutor<DayDescriptionEntity> {

    @Query("SELECT e FROM EventDescriptionEntity e WHERE e.programmedEventId = :id")
    Optional<EventDescriptionEntity> findByEventId(@Param("id") Long id);
}
