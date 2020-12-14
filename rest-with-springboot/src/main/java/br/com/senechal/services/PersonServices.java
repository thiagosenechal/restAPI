package br.com.senechal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senechal.exception.ResourceNotFound;
import br.com.senechal.model.Person;
import br.com.senechal.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);		
	}
	
	public Person update(Person person) {
		
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFound("No record found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getFirstName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());	
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("No record found for this ID"));
		
		repository.delete(entity);

	}	
	
	public List<Person> findAll() {

		return repository.findAll();
		
	}
	
	public Person findById(Long id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("No record found for this ID"));
		
	} 	

}
