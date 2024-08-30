package com.architrack.architrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.architrack.architrack.entities.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
