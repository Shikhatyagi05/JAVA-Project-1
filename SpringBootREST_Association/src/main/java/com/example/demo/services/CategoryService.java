package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository crepo;
	
	public Category getOne(int cid)
	{
		return crepo.findById(cid).get();
	}
	
	public List<Category> getAll()
	{
		return crepo.findAll();
	}
	
	public Category save(Category c)
	{
		return crepo.save(c);
	}
	
}
