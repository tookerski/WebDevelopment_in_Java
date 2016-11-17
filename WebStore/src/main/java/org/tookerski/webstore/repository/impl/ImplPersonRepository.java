package org.tookerski.webstore.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.tookerski.webstore.model.Person;
import org.tookerski.webstore.repository.PersonRepository;

public class ImplPersonRepository implements PersonRepository {

	private List<Person> personList = new ArrayList<Person>();
	
	public ImplPersonRepository(){
		Person buyer = new Person(1,"buyer","37254660e226ea65ce6f1efd54233424","buyer",false);
		Person seller = new Person(1,"seller","981c57a5cfb0f868e064904b8745766f","seller",true);
		personList.add(buyer);
		personList.add(seller);
	}
	
	@Override
	public List<Person> getAllPerson() {
		return personList;
	}

	@Override
	public Person getPersonById(int id) {
		Person personById = null;
		for (Person person:personList){
			if(person!=null&&person.getUserId()!=0&&person.getUserId()==id){
				personById = person;
				break;
			}
		}
		if (personById == null){
			throw new IllegalArgumentException("No products found with the product id: "+id);
		}
		return personById;
	}

}
