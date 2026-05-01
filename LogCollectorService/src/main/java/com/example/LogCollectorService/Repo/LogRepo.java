package com.example.LogCollectorService.Repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LogCollectorService.Entity.Log;

@Repository
public interface LogRepo extends JpaRepository<Log , UUID> {

     List<Log> findByTraceId(String traceId);

     List<Log> findByLevelIgnoreCase(String level);

}
