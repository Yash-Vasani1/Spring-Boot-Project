package com.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.subcategory;

@Repository
public interface scategoryRepository extends CrudRepository<subcategory, Integer>{
	
}
