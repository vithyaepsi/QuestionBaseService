package com.vithya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vithya.questions.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
	People findByFirstnameAndAge(String firstname, int age);
}
