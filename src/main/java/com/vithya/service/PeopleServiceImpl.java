package com.vithya.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vithya.questions.model.People;
import com.vithya.repository.PeopleRepository;
import com.vithya.service.base.BaseService;

@Service
public class PeopleServiceImpl extends BaseService<People, Integer> {
	@Autowired 
	private PeopleRepository peopleRepository;
	
	@Transactional(rollbackOn = EntityNotFoundException.class)
	public People findByFirstnameAndAge(String firstname, int age){
		return peopleRepository.findByFirstnameAndAge(firstname, age);
	}
	
}
