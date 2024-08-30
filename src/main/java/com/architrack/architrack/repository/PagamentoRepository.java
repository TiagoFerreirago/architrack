package com.architrack.architrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.architrack.architrack.entities.Pagamentos;

public interface PagamentoRepository extends JpaRepository<Pagamentos, Long> {

}
