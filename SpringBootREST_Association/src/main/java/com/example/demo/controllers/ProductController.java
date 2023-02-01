package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@GetMapping("/getProduct")
	public Product getOne(@RequestParam("pr_id") int pid)
	{
		return pservice.getOne(pid);
	}

	@GetMapping("/getAllP")
	public List<Product> getAll()
	{
		return pservice.getAll();
	}
}
