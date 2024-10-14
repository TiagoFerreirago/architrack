package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.architrack.architrack.controller.DocumentoController;
import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Documento;
import com.architrack.architrack.entities.v1.vo.DocumentoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.DocumentoRepository;

@Service
public class DocumentoService {

	@Autowired
	private DocumentoRepository repository;
	

	public DocumentoVo findById(Long id) {
		Documento documento = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		DocumentoVo vo = DozerMapper.parseObjectForEntity(documento, DocumentoVo.class);
		vo.add(linkTo(methodOn(DocumentoController.class).findById(id)).withSelfRel());
		return vo;
		
	}
	
	public List<DocumentoVo> findAll() {
		List<Documento>documento = repository.findAll();
		List<DocumentoVo>listVo = DozerMapper.parseListObjectForEntity(documento, DocumentoVo.class);
		listVo.stream().forEach(x -> x.add(linkTo(methodOn(DocumentoController.class).findById(x.getKey())).withSelfRel()));
		return listVo;
	}
	
	public DocumentoVo create(DocumentoVo documento) {
		Documento arq = DozerMapper.parseObjectForEntity(documento, Documento.class);
		DocumentoVo vo = DozerMapper.parseObjectForEntity(repository.save(arq), DocumentoVo.class);
		vo.add(linkTo(methodOn(DocumentoController.class).findById(arq.getId())).withSelfRel());
		return vo;
	}
	
	public DocumentoVo update(DocumentoVo documento) {
		Documento doc = repository.findById(documento.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		doc.setCliente(documento.getCliente());
		doc.setDataEnvio(documento.getDataEnvio());
		doc.setNomeDocumento(documento.getNomeDocumento());
		doc.setProjeto(documento.getProjeto());
		doc.setTipoDocumento(documento.getTipoDocumento());
		
		DocumentoVo vo = DozerMapper.parseObjectForEntity(repository.save(doc), DocumentoVo.class);
		vo.add(linkTo(methodOn(DocumentoController.class).findById(doc.getId())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		Documento documento = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(documento);
	}
}
