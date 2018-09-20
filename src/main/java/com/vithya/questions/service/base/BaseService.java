package com.vithya.questions.service.base;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseService<REPO extends JpaRepository<C, Integer>, C> {

	@Autowired
	protected REPO repository;
	
	@Transactional(rollbackOn = EntityNotFoundException.class)
	public void save(C thing){
		this.repository.save(thing);
	}
	
	@Transactional(rollbackOn = EntityNotFoundException.class)
	public List<C> findAll(){
		final List<C> thing = this.repository.findAll();
		if( thing == null ) {
			throw new EntityNotFoundException();
		}
		return thing;
	}
	
	
}
