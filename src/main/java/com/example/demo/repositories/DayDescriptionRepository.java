package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.DayDescriptionEntity;

@Repository
public interface DayDescriptionRepository extends JpaRepository<DayDescriptionEntity, Long>, JpaSpecificationExecutor<DayDescriptionEntity>{
    

    @Query("Select e FROM DayDescriptionEntity e WHERE e.programmedEventId = :id")
    Optional<DayDescriptionEntity> findByEventId(@Param("id") Long id);
}
