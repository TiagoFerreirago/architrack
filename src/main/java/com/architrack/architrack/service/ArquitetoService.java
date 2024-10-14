package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.architrack.architrack.controller.ArquitetoController;
import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Arquiteto;
import com.architrack.architrack.entities.v1.vo.ArquitetoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.ArquitetoRepository;

@Service
public class ArquitetoService {

	@Autowired
	private ArquitetoRepository repository;
	
	


	public ArquitetoVo findById(Long id) {
		Arquiteto arquiteto = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		ArquitetoVo vo = DozerMapper.parseObjectForEntity(arquiteto, ArquitetoVo.class);
		vo.add(linkTo(methodOn(ArquitetoController.class).findById(id)).withSelfRel());
		return vo;
		
	}
	
	public List<ArquitetoVo> findAll() {
		List<Arquiteto>arquiteto = repository.findAll();
		List<ArquitetoVo>listVo = DozerMapper.parseListObjectForEntity(arquiteto, ArquitetoVo.class);
		listVo.stream().forEach(x -> x.add(linkTo(methodOn(ArquitetoController.class).findById(x.getKey())).withSelfRel()));
		return listVo;
	}
	
	public ArquitetoVo create(ArquitetoVo arquiteto) {
		Arquiteto arq = DozerMapper.parseObjectForEntity(arquiteto, Arquiteto.class);
		ArquitetoVo vo = DozerMapper.parseObjectForEntity(repository.save(arq), ArquitetoVo.class);
		vo.add(linkTo(methodOn(ArquitetoController.class).findById(arq.getId())).withSelfRel());
		return vo;
	}
	
	public ArquitetoVo update(ArquitetoVo arquiteto) {
		Arquiteto arq = repository.findById(arquiteto.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		arq.setEmail(arquiteto.getEmail());;
		arq.setEnderecos(arquiteto.getEnderecos());
		arq.setNome(arquiteto.getNome());
		arq.setProjetos(arquiteto.getProjetos());
		arq.setTelefone(arquiteto.getTelefone());
		arq.setTipo(arquiteto.getTipo());
		
		ArquitetoVo vo = DozerMapper.parseObjectForEntity(repository.save(arq), ArquitetoVo.class);
		vo.add(linkTo(methodOn(ArquitetoController.class).findById(arq.getId())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		Arquiteto arquiteto = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(arquiteto);
	}

}
