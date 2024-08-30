package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Agenda;
import com.architrack.architrack.entities.v1.vo.AgendaVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repository;
	
	private DozerMapper mapper;
	
	
	public AgendaVo findById(Long id) {
		Agenda entity = repository.findById(id).orElseThrow( () -> 
		 new ResponseNotFoundHandlerException("Id not found"));
		AgendaVo vo = mapper.parseObjectForEntity(entity, AgendaVo.class);
		return vo;
	}
	
	public List<AgendaVo> findAll() {
		List<Agenda>list = repository.findAll();
		List<AgendaVo>listVo = mapper.parseListObjectForEntity(list, AgendaVo.class);
		return listVo;
	}

	public AgendaVo update(AgendaVo agenda) {
		Agenda entity = repository.findById(agenda.getKey()).orElseThrow( () -> 
		new ResponseNotFoundHandlerException("Id not found"));
		entity.setDataFim(agenda.getDataFim());
		entity.setDataInicio(agenda.getDataInicio());
		entity.setProjeto(agenda.getProjeto());
		AgendaVo vo = mapper.parseObjectForEntity(repository.save(entity), AgendaVo.class);
		return vo;
	
}
	public AgendaVo create(AgendaVo agenda) {
		
		Agenda entity = new Agenda();
		entity.setDataFim(agenda.getDataFim());
		entity.setDataInicio(agenda.getDataInicio());
		entity.setProjeto(agenda.getProjeto());
		AgendaVo vo = mapper.parseObjectForEntity(repository.save(entity), AgendaVo.class);
		return vo;
	}
	
	public void delete(Long id) {
		Agenda agenda = repository.findById(id).orElseThrow(
				() ->  new ResponseNotFoundHandlerException("Id not found"));
		
		repository.delete(agenda);
	}
}
