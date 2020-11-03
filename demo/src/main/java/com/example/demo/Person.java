package com.example.demo;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Person {
	
	@Id
	public String id;
	
	public String name;

}
