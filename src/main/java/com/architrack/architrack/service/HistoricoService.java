package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Historico;
import com.architrack.architrack.entities.v1.vo.HistoricoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.HistoricoRepository;

@Service
public class HistoricoService {

	@Autowired
	private HistoricoRepository repository;
	
	public DozerMapper mapper;
	
	
	public HistoricoVo findById(Long id) {
		Historico historico = repository.findById(id).orElseThrow( 
				() -> new ResponseNotFoundHandlerException("Id not found"));
		HistoricoVo vo = mapper.parseObjectForEntity(historico, HistoricoVo.class);
		return vo;
	}
	
	public List<HistoricoVo> findAll(){
		List<Historico>list = repository.findAll();
		List<HistoricoVo>listVo = mapper.parseListObjectForEntity(list, HistoricoVo.class);
		return listVo;
	}
	
	public HistoricoVo create(HistoricoVo historico) {
		Historico hist = mapper.parseObjectForEntity(historico, Historico.class);
		HistoricoVo vo = mapper.parseObjectForEntity(repository.save(hist),HistoricoVo.class);
		return vo;
	}
	
	public HistoricoVo update(HistoricoVo historico) {
		Historico hist = repository.findById(historico.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		hist.setDataMudanca(historico.getDataMudanca());
		hist.setDescricaoMudanca(historico.getDescricaoMudanca());
		hist.setProjeto(historico.getProjeto());
		HistoricoVo vo = mapper.parseObjectForEntity(repository.save(hist), HistoricoVo.class);
		return vo;
	}
	
	public void delete(Long id) {
		Historico hist = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(hist);
	}
}
