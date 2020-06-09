package com.rahimi.SpringDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.rahimi.SpringDataJPA.model.Users;

@Component
public interface UserJPARepository extends JpaRepository<Users, Long>{

	Users findByName(String name); // Spring JPA is going to convert this findByName() into a query /select * from Users where name='name'
	//Convension findBy+FieldName()

}
