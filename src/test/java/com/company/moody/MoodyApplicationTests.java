package com.company.moody;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.company.moody.entities.Mood;
import com.company.moody.entities.Mood.MoodType;
import com.company.moody.repositories.MoodRepository;


@DataJpaTest
class MoodyApplicationTests {
	@Autowired
	private MoodRepository moodRepository;
	@Test
	public void testNewMoodSave(){
		var mood = new Mood(MoodType.GOOD, "");
		moodRepository.save(mood);

		System.out.println("TEST");
	}

}
