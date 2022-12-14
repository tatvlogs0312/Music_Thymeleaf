package com.example.musicbackend.repository;

import com.example.musicbackend.entity.National;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalRepository extends JpaRepository<National, Long> {
}