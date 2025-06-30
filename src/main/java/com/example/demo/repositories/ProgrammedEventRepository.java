package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.ProgrammedEventEntity;

@Repository
public interface ProgrammedEventRepository extends JpaRepository<ProgrammedEventEntity, Long>{
    

    @Query("select e from ProgrammedEventEntity e where e.dateTime = :dayTime")
    List<ProgrammedEventEntity> getProgrammedEventsForDateTime(@Param("dayTime") LocalDateTime dayTime);

    @Query("SELECT e FROM ProgrammedEventEntity e WHERE e.dateTime BETWEEN :start AND :end")
    List<ProgrammedEventEntity> getProgrammedEventsForDate(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

}
