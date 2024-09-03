package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Endereco;
import com.architrack.architrack.entities.v1.vo.EnderecoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.EnderecoRepository;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	private DozerMapper mapper;


	public EnderecoVo findById(Long id) {
		Endereco endereco = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		EnderecoVo vo = mapper.parseObjectForEntity(endereco, EnderecoVo.class);
		return vo;
		
	}
	
	public List<EnderecoVo> findAll() {
		List<Endereco>endereco = repository.findAll();
		List<EnderecoVo>listVo = mapper.parseListObjectForEntity(endereco, EnderecoVo.class);
		return listVo;
	}
	
	public EnderecoVo create(EnderecoVo endereco) {
		Endereco arq = mapper.parseObjectForEntity(endereco, Endereco.class);
		EnderecoVo vo = mapper.parseObjectForEntity(repository.save(arq), EnderecoVo.class);
		return vo;
	}
	
	public EnderecoVo update(EnderecoVo endereco) {
		Endereco end = repository.findById(endereco.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		end.setArquiteto(endereco.getArquiteto());
		end.setBairro(endereco.getBairro());
		end.setCep(endereco.getCep());
		end.setCidade(endereco.getCidade());
		end.setCliente(endereco.getCliente());
		end.setEstado(endereco.getEstado());
		end.setRua(endereco.getRua());
		
		EnderecoVo vo = mapper.parseObjectForEntity(repository.save(end), EnderecoVo.class);
		return vo;
	}
	
	public void delete(Long id) {
		Endereco endereco = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(endereco);
	}
}
