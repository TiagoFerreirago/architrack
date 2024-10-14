package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.architrack.architrack.controller.PagamentoController;
import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Pagamentos;
import com.architrack.architrack.entities.v1.vo.PagamentosVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repository;
		
	
	public PagamentosVo findById(Long id) {
		Pagamentos pagamentos = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		PagamentosVo vo = DozerMapper.parseObjectForEntity(pagamentos, PagamentosVo.class);
		vo.add(linkTo(methodOn(PagamentoController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public List<PagamentosVo> findAll(){
		
		List<Pagamentos> pagamentos = repository.findAll();
		List<PagamentosVo> listVo = DozerMapper.parseListObjectForEntity(pagamentos, PagamentosVo.class);
		listVo.stream().forEach(x -> x.add(linkTo(methodOn(PagamentoController.class).findById(x.getKey())).withSelfRel()));
		return listVo;
	}
	
	public PagamentosVo create(PagamentosVo pagamentos) {
		Pagamentos pag = DozerMapper.parseObjectForEntity(pagamentos, Pagamentos.class);
		PagamentosVo vo = DozerMapper.parseObjectForEntity(repository.save(pag), PagamentosVo.class);
		vo.add(linkTo(methodOn(PagamentoController.class).findById(pag.getId())).withSelfRel());
		return vo;
	}
	
	public PagamentosVo update(PagamentosVo pagamentos) {
		Pagamentos pag= repository.findById(pagamentos.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		pag.setDataPagamento(pagamentos.getDataPagamento());
		pag.setProjeto(pagamentos.getProjeto());
		pag.setStatus(pagamentos.getStatus());
		pag.setValor(pagamentos.getValor());
		PagamentosVo vo = DozerMapper.parseObjectForEntity(repository.save(pag), PagamentosVo.class);
		vo.add(linkTo(methodOn(PagamentoController.class).findById(pag.getId())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		Pagamentos pag= repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(pag);
	}
}
