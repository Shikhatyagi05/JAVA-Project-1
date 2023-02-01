package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.services.Studentservice;

@RestController
public class StudentController
{
	@Autowired
	Studentservice sservice;
	@GetMapping("/all")
	public List<Student> getAll()
	{
		return sservice.getAll();
	}
	@PostMapping("/save") //body-> raw -> json
	public Student save(@RequestBody Student c)
	{
		return sservice.save(c);
	}
	@GetMapping("/getone")  
	public Student getOne(@RequestParam("sid") int id)
	{
		return sservice.getOne(id);
	}
	@GetMapping("/getper")  
	public List<Student> getPercentage(@RequestParam("per") double per)
	{
		return sservice.getPerc(per);
	}
	
}
