package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;

@Repository
@Transactional
public interface Studentrepositry extends JpaRepository<Student, Integer>
{
	@Query("select s from Student s where s.percent> :per")
	public List<Student> getPerc(double per);
	
	
}
