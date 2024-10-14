package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.architrack.architrack.controller.HistoricoController;
import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Historico;
import com.architrack.architrack.entities.v1.vo.HistoricoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.HistoricoRepository;

@Service
public class HistoricoService {

	@Autowired
	private HistoricoRepository repository;
		
	
	public HistoricoVo findById(Long id) {
		Historico historico = repository.findById(id).orElseThrow( 
				() -> new ResponseNotFoundHandlerException("Id not found"));
		HistoricoVo vo = DozerMapper.parseObjectForEntity(historico, HistoricoVo.class);
		vo.add(linkTo(methodOn(HistoricoController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public List<HistoricoVo> findAll(){
		List<Historico>list = repository.findAll();
		List<HistoricoVo>listVo = DozerMapper.parseListObjectForEntity(list, HistoricoVo.class);
		listVo.stream().forEach(x -> x.add(linkTo(methodOn(HistoricoController.class).findById(x.getKey())).withSelfRel()));
		return listVo;
	}
	
	public HistoricoVo create(HistoricoVo historico) {
		Historico hist = DozerMapper.parseObjectForEntity(historico, Historico.class);
		HistoricoVo vo = DozerMapper.parseObjectForEntity(repository.save(hist),HistoricoVo.class);
		vo.add(linkTo(methodOn(HistoricoController.class).findById(hist.getId())).withSelfRel());
		return vo;
	}
	
	public HistoricoVo update(HistoricoVo historico) {
		Historico hist = repository.findById(historico.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		hist.setDataMudanca(historico.getDataMudanca());
		hist.setDescricaoMudanca(historico.getDescricaoMudanca());
		hist.setProjeto(historico.getProjeto());
		HistoricoVo vo = DozerMapper.parseObjectForEntity(repository.save(hist), HistoricoVo.class);
		vo.add(linkTo(methodOn(HistoricoController.class).findById(hist.getId())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		Historico hist = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(hist);
	}
}
