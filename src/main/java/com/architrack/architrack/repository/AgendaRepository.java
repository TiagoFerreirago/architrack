package com.architrack.architrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.architrack.architrack.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
