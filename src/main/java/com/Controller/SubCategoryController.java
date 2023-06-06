package com.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bean.UserBean;
import com.Entity.category;
import com.Entity.subcategory;
import com.Repository.categoryRepository;
import com.Repository.scategoryRepository;

@RestController
public class SubCategoryController {
	@Autowired
	categoryRepository catrepo;
	
	@Autowired
	scategoryRepository scatrepo;
	
	@PostMapping("/AddSubCategory")
	public ResponseEntity<UserBean<subcategory>> AddSubCategory(@RequestBody subcategory scat)
	{
		UserBean<subcategory> res = new UserBean<>();
		String catname = scat.getCategory1().getCname();
		category cat = catrepo.findByCname(catname);
		if(cat==null)
		{
			catrepo.save(scat.getCategory1());
//			cat = catrepo.findByCname(catname);
//			scat.setCategory1(cat);
			scatrepo.save(scat);
			res.setData(scat);
			res.setMsg("cat and scat added sucessfully !!");
			return ResponseEntity.ok(res);
		}
		else
		{
			scat.setCategory1(cat);
			scatrepo.save(scat);	
			res.setData(scat);
			res.setMsg("scat added sucessfully !!");
			return ResponseEntity.ok(res);
		}
	}
	@GetMapping("/GetAllSCategory")
	public ResponseEntity<UserBean<List<subcategory>>> GetAllSCategory()
	{
		List<subcategory> list = new ArrayList<>();
		list = (List<subcategory>) scatrepo.findAll();
		UserBean<List<subcategory>> res = new UserBean<>();
		res.setData(list);
//		res.setData(list);
		res.setMsg("cat and scat added sucessfully !!");
		return ResponseEntity.ok(res); 
	}
	
	@GetMapping("/GetSCategory/{id}")
	public ResponseEntity<UserBean<subcategory>> GetSCategoryById(@PathVariable("id") Integer id)
	{
		UserBean<subcategory> res = new UserBean<>();
		Optional<subcategory> temp = scatrepo.findById(id); 
		if(!temp.isEmpty())
			res.setData(temp.get());
		else
			res.setData(null);
//		res.setData(scatrepo.findById(id));
		res.setMsg("Sucessfully find by Id !!");
		return ResponseEntity.ok(res);
	}
	
}