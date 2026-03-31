package com.company.moody.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.moody.entities.Mood;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
    
}
