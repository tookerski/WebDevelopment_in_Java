package org.tookerski.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tookerski.webstore.model.Person;
import org.tookerski.webstore.repository.PersonRepository;
import org.tookerski.webstore.service.PersonService;

@Service
public class ImplPersonService implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAllPerson() {
		return personRepository.getAllPerson();
	}

	@Override
	public Person getPersonById(int id) {
		return personRepository.getPersonById(id);
	}

}
