package com.estudo.agendaSpring.repository;

import com.estudo.agendaSpring.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
