package com.company.moody.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;

@Entity
@Table(name="moods")
@Data
public class Mood {
    @Transactional
    public static enum MoodType{
        GOOD, NEUTRAL, BAD;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private MoodType moodType;

    private String description;

    private LocalDate date;

    public Mood(MoodType moodType, String description, LocalDate date){
        this.moodType = moodType;
        this.description = description;
        this.date = date;
    }

    public Mood(MoodType moodType, String description){
        this.moodType = moodType;
        this.description = description;
        this.date = LocalDate.now();
    }
}
