package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	void testInsert1000Docs() {
		personRepository.deleteAll();
		Assertions.assertEquals(0, personRepository.count());
		
		List<Person> personen = Stream.iterate(1, i -> i+1).limit(1000) //
			.map(i -> {
				Person person = new Person();
				person.setName("Person "+ i);
				return person;
			}) //
			.collect(Collectors.toList());
		personRepository.insert(personen);
		Assertions.assertEquals(1000, personRepository.count());
	}

}
