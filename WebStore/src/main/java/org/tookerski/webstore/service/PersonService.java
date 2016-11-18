package org.tookerski.webstore.service;

import java.util.List;

import org.tookerski.webstore.model.Person;

public interface PersonService {

	List<Person> getAllPerson();
	Person getPersonById(int id);
}
