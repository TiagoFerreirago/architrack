package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.architrack.architrack.controller.ProjetoController;
import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Projeto;
import com.architrack.architrack.entities.v1.vo.ProjetoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;
	
	
	public ProjetoVo findById(Long id) {
		
		Projeto projeto = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		ProjetoVo vo = DozerMapper.parseObjectForEntity(projeto, ProjetoVo.class);
		vo.add(linkTo(methodOn(ProjetoController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public List<ProjetoVo> findAll(){
		List<Projeto> projetos = repository.findAll();
		List<ProjetoVo> listVo = DozerMapper.parseListObjectForEntity(projetos, ProjetoVo.class);
		listVo.stream().forEach(x -> x.add(linkTo(methodOn(ProjetoController.class).findById(x.getKey())).withSelfRel()));
		return listVo;
	}
	
	public ProjetoVo create(ProjetoVo projeto) {
		Projeto proj = DozerMapper.parseObjectForEntity(projeto, Projeto.class);
		ProjetoVo vo = DozerMapper.parseObjectForEntity(repository.save(proj), ProjetoVo.class);
		vo.add(linkTo(methodOn(ProjetoController.class).findById(proj.getId())).withSelfRel());
		return vo;
	}
	
	public ProjetoVo update(ProjetoVo projeto) {
		Projeto proj = repository.findById(projeto.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		proj.setAgendamentos(projeto.getAgendamentos());
		proj.setAreaEmpreendimento(projeto.getAreaEmpreendimento());
		proj.setArquitetos(projeto.getArquitetos());
		proj.setCliente(projeto.getCliente());
		proj.setDocumentos(projeto.getDocumentos());
		proj.setListaHistorico(projeto.getListaHistorico());
		proj.setPagamentos(projeto.getPagamentos());
		ProjetoVo vo = DozerMapper.parseObjectForEntity(repository.save(proj), ProjetoVo.class);
		vo.add(linkTo(methodOn(ProjetoController.class).findById(proj.getId())).withSelfRel());
		return vo;
				
	}
	
	public void delete(Long id) {
		
		Projeto proj = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(proj);
	}
}
