package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	
	@Column
	String pname;
	
	@JsonIgnoreProperties("products")
	@ManyToOne
	@JoinColumn(name= "cid")
	//save primary key of category
	Category category; //cid,cname,products

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(int pid, String pname, Category category) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.category = category;
	}



	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	} 
	
	
}
