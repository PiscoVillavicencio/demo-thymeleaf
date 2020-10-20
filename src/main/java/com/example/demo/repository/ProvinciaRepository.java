package com.example.demo.repository;

import com.example.demo.model.entity.ProvinciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaRepository extends JpaRepository<ProvinciaEntity, Long> {
}
