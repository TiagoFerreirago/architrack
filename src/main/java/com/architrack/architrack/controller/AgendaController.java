package com.architrack.architrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architrack.architrack.entities.v1.vo.AgendaVo;
import com.architrack.architrack.mediatype.MediaType;
import com.architrack.architrack.service.AgendaService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/agenda")

public class AgendaController {

	@Autowired
	private AgendaService service;
	
	@GetMapping(value = "/{id}",
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public AgendaVo findById(@PathParam(value = "id") Long id) {
		return service.findById(id);
	}
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public List<AgendaVo> findAll() {
		return service.findAll();
	}
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public AgendaVo create(@RequestBody AgendaVo agenda) {
		return service.create(agenda);
	}
	@PutMapping(produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public AgendaVo update(@RequestBody AgendaVo agenda) {
		return service.update(agenda);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AgendaVo> delete(@PathParam(value = "id")Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
