package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Arquiteto;
import com.architrack.architrack.entities.v1.vo.ArquitetoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.ArquitetoRepository;

@Service
public class ArquitetoService {

	@Autowired
	private ArquitetoRepository repository;
	
	private DozerMapper mapper;


	public ArquitetoVo findById(Long id) {
		Arquiteto arquiteto = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		ArquitetoVo vo = mapper.parseObjectForEntity(arquiteto, ArquitetoVo.class);
		return vo;
		
	}
	
	public List<ArquitetoVo> findAll() {
		List<Arquiteto>arquiteto = repository.findAll();
		List<ArquitetoVo>listVo = mapper.parseListObjectForEntity(arquiteto, ArquitetoVo.class);
		return listVo;
	}
	
	public ArquitetoVo cliente(ArquitetoVo arquiteto) {
		Arquiteto arq = mapper.parseObjectForEntity(arquiteto, Arquiteto.class);
		ArquitetoVo vo = mapper.parseObjectForEntity(repository.save(arq), ArquitetoVo.class);
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
		
		ArquitetoVo vo = mapper.parseObjectForEntity(repository.save(arq), ArquitetoVo.class);
		return vo;
	}
	
	public void delete(Long id) {
		Arquiteto arquiteto = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(arquiteto);
	}

}
