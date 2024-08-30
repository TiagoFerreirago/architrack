package com.architrack.architrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.architrack.architrack.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
