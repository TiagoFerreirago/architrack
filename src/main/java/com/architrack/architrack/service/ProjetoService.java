package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Projeto;
import com.architrack.architrack.entities.v1.vo.ProjetoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;
	
	private DozerMapper mapper;
	
	public ProjetoVo findById(Long id) {
		
		Projeto projeto = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		ProjetoVo vo = mapper.parseObjectForEntity(projeto, ProjetoVo.class);
		return vo;
	}
	
	public List<ProjetoVo> findAll(){
		List<Projeto> projetos = repository.findAll();
		List<ProjetoVo> listVo = mapper.parseListObjectForEntity(projetos, ProjetoVo.class);
		return listVo;
	}
	
	public ProjetoVo create(ProjetoVo projeto) {
		Projeto proj = mapper.parseObjectForEntity(projeto, Projeto.class);
		ProjetoVo vo = mapper.parseObjectForEntity(repository.save(proj), ProjetoVo.class);
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
		ProjetoVo vo = mapper.parseObjectForEntity(repository.save(proj), ProjetoVo.class);
		return vo;
				
	}
	
	public void delete(Long id) {
		
		Projeto proj = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(proj);
	}
}
