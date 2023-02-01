package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService cservice;
	
	@GetMapping("/getCategory")
	public Category getOne(@RequestParam("catid") int cid)
	{
		return cservice.getOne(cid);
	}
		
	@GetMapping("/getAllC")
	public List<Category> getAll()
	{
		return cservice.getAll();
	}
	
	@PostMapping("/savecat")
	public Category save(@RequestBody Category c)
	{
		return cservice.save(c);
				
	}
	
	
}
