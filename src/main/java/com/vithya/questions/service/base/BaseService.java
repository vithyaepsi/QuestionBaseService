package com.vithya.questions.service.base;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseService<T, K> {

	@Autowired
	protected JpaRepository<T, K> genericRepository;
	
	@Transactional(rollbackOn = EntityNotFoundException.class)
	public void save(T thing){
		this.genericRepository.save(thing);
	}
	
	@Transactional(rollbackOn = EntityNotFoundException.class)
	public List<T> findAll(){
		final List<T> thing = this.genericRepository.findAll();
		if( thing == null ) {
			throw new EntityNotFoundException();
		}
		return thing;
	}
	
	
}
