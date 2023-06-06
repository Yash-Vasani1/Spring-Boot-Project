package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.category;
import com.Repository.categoryRepository;
import com.Repository.scategoryRepository;

@RestController
public class CategoryController {
	
	@Autowired
	categoryRepository catrepo;
	
	@Autowired
	scategoryRepository scatrepo;
	
	@PostMapping("/addcategory")
	public category AddCategory(@RequestBody category cat)
	{
		catrepo.save(cat);
		return cat;
	}
}
