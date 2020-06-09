package com.rahimi.SpringDataJPA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahimi.SpringDataJPA.model.Users;
import com.rahimi.SpringDataJPA.repository.UserJPARepository;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserJPARepository userJPARepository;

	//GET
	//to get all user
	@GetMapping("/all")
	public List<Users> findAll()
	{
		return userJPARepository.findAll(); //findAll() method is implemented ins Spring JpaRepository, which fetch and returns all the records from database using the give entity 
	}
	//to get a specific user by name
	@GetMapping(value = "/{name}")
	public Users findByName(@PathVariable final String name)
	{
		return userJPARepository.findByName(name);
	}
	
	
	//POST : to load the data to the database
	@PostMapping(value = "/load")
	public Users load(@RequestBody final Users users)
	{
		userJPARepository.save(users);
		return userJPARepository.findByName(users.getName());
	}

}
