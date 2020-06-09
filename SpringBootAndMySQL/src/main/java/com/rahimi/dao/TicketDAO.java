package com.rahimi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahimi.model.Ticket;

@Repository
public interface TicketDAO extends JpaRepository<Ticket, Integer> {

}
