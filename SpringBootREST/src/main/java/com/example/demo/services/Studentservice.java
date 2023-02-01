package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.Studentrepositry;

@Service
public class Studentservice
{
	@Autowired
	Studentrepositry srepo;

	public List<Student> getAll()
	{
		return srepo.findAll();
	}
	public Student getOne(int id)
	{
		Optional<Student> stud = srepo.findById(id);
		Student s =null;
		try
		{
			s = stud.get();
		}
		catch(NoSuchElementException e)
		{
			s=null;
		}
		return s;
	}
	public Student save(Student s)
	{
		return srepo.save(s);
	}
	public List<Student> getPerc(double per)
	{
		return srepo.getPerc(per);
	}
	
}
