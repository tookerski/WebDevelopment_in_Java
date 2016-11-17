package org.tookerski.webstore.repository;

import java.util.List;

import org.tookerski.webstore.model.Person;

public interface PersonRepository {
	List<Person> getAllPerson();
	Person getPersonById(int id);
}
