package com.vithya.questions.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vithya.questions.model.People;
import com.vithya.questions.repository.PeopleRepository;
import com.vithya.questions.service.base.BaseService;

@Service
public class PeopleServiceImpl extends BaseService<PeopleRepository, People> {
	
	@Transactional(rollbackOn = EntityNotFoundException.class)
	public People findByFirstnameAndAge(String firstname, int age){
		return this.repository.findByFirstnameAndAge(firstname, age);
	}
	
}
