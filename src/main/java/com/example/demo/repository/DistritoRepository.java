package com.example.demo.repository;

import com.example.demo.model.entity.DistritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritoRepository extends JpaRepository<DistritoEntity, Long> {
}
