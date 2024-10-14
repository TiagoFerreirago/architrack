package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.architrack.architrack.controller.EnderecoController;
import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Endereco;
import com.architrack.architrack.entities.v1.vo.EnderecoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.EnderecoRepository;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	

	public EnderecoVo findById(Long id) {
		Endereco endereco = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		EnderecoVo vo = DozerMapper.parseObjectForEntity(endereco, EnderecoVo.class);
		vo.add(linkTo(methodOn(EnderecoController.class).findById(id)).withSelfRel());
		return vo;
		
	}
	
	public List<EnderecoVo> findAll() {
		List<Endereco>endereco = repository.findAll();
		List<EnderecoVo>listVo = DozerMapper.parseListObjectForEntity(endereco, EnderecoVo.class);
		listVo.stream().forEach(x -> x.add(linkTo(methodOn(EnderecoController.class).findById(x.getKey())).withSelfRel()));
		return listVo;
	}
	
	public EnderecoVo create(EnderecoVo endereco) {
		Endereco arq = DozerMapper.parseObjectForEntity(endereco, Endereco.class);
		EnderecoVo vo = DozerMapper.parseObjectForEntity(repository.save(arq), EnderecoVo.class);
		vo.add(linkTo(methodOn(EnderecoController.class).findById(arq.getId())).withSelfRel());
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
		
		EnderecoVo vo = DozerMapper.parseObjectForEntity(repository.save(end), EnderecoVo.class);
		vo.add(linkTo(methodOn(EnderecoController.class).findById(end.getId())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		Endereco endereco = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(endereco);
	}
}
