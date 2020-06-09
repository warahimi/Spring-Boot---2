package com.rahimi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahimi.dao.TicketDAO;
import com.rahimi.model.Ticket;

@RestController
@RequestMapping("/ticket") //root url
public class TicketController {
	@Autowired
	private TicketDAO dao;
	
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets)
	{
		dao.saveAll(tickets);
		return "Tickets booked: "+tickets.size();
	}
	
	@GetMapping("/getTickets")
	public List<Ticket> geTickets()
	{
		return dao.findAll();
	}
	

}
