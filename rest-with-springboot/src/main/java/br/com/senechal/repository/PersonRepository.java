package br.com.senechal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senechal.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
