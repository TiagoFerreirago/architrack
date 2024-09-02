package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Pagamentos;
import com.architrack.architrack.entities.v1.vo.PagamentosVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repository;
	
	private DozerMapper mapper;
	
	
	public PagamentosVo findById(Long id) {
		Pagamentos pagamentos = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		PagamentosVo vo = mapper.parseObjectForEntity(pagamentos, PagamentosVo.class);
		return vo;
	}
	
	public List<PagamentosVo> findAll(){
		
		List<Pagamentos> pagamentos = repository.findAll();
		List<PagamentosVo> listVo = mapper.parseListObjectForEntity(pagamentos, PagamentosVo.class);
		return listVo;
	}
	
	public PagamentosVo create(PagamentosVo pagamentos) {
		Pagamentos pag = mapper.parseObjectForEntity(pagamentos, Pagamentos.class);
		PagamentosVo vo = mapper.parseObjectForEntity(repository.save(pag), PagamentosVo.class);
		return vo;
	}
	
	public PagamentosVo update(PagamentosVo pagamentos) {
		Pagamentos pag= repository.findById(pagamentos.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		pag.setDataPagamento(pagamentos.getDataPagamento());
		pag.setProjeto(pagamentos.getProjeto());
		pag.setStatus(pagamentos.getStatus());
		pag.setValor(pagamentos.getValor());
		PagamentosVo vo = mapper.parseObjectForEntity(repository.save(pag), PagamentosVo.class);
		return vo;
	}
	
	public void delete(Long id) {
		Pagamentos pag= repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(pag);
	}
}
