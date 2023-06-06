package com.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.category;

@Repository
public interface categoryRepository extends CrudRepository<category, Integer> {

//	category findByCName(String catname);

	category findByCname(String catname);
	
}
