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

import com.architrack.architrack.entities.v1.vo.DocumentoVo;
import com.architrack.architrack.mediatype.MediaType;
import com.architrack.architrack.service.DocumentoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/documento")
public class DocumentoController {

	@Autowired
	private DocumentoService service;
	
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public DocumentoVo findById(@PathParam(value = "id")Long id) {
		return service.findById(id);
	}
	@GetMapping(produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public List<DocumentoVo> findAll() {
		return service.findAll();
	}
	@PostMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public DocumentoVo create(@RequestBody DocumentoVo documento) {
		return service.create(documento);
	}
	@PutMapping(consumes = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML},
			produces = {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.APPLICATION_YML})
	public DocumentoVo update(@RequestBody DocumentoVo documento) {
		return service.update(documento);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<DocumentoVo>delete(@PathParam(value = "id")Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}