package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.architrack.architrack.controller.ClienteController;
import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Cliente;
import com.architrack.architrack.entities.v1.vo.ClienteVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	private  ClienteRepository repository;
	

	public ClienteVo findById(Long id) {
		Cliente cliente = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		ClienteVo vo = DozerMapper.parseObjectForEntity(cliente, ClienteVo.class);
		vo.add(linkTo(methodOn(ClienteController.class).findById(id)).withSelfRel());
		return vo;
		
	}
	
	public List<ClienteVo> findAll() {
		List<Cliente>cliente = repository.findAll();
		List<ClienteVo>listVo = DozerMapper.parseListObjectForEntity(cliente, ClienteVo.class);
		listVo.stream().forEach(x -> x.add(linkTo(methodOn(ClienteController.class).findById(x.getKey())).withSelfRel()));
		return listVo;
	}
	
	public ClienteVo create(ClienteVo cliente) {
		Cliente cli = DozerMapper.parseObjectForEntity(cliente, Cliente.class);
		ClienteVo vo = DozerMapper.parseObjectForEntity(repository.save(cli), ClienteVo.class);
		vo.add(linkTo(methodOn(ClienteController.class).findById(cli.getId())).withSelfRel());
		return vo;
	}
	
	public ClienteVo update(ClienteVo cliente) {
		Cliente cli = repository.findById(cliente.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		cli.setEmail(cliente.getEmail());;
		cli.setEnderecos(cliente.getEnderecos());
		cli.setNome(cliente.getNome());
		cli.setDocumentos(cliente.getDocumentos());
		cli.setNome(cliente.getNome());
		cli.setPf(cliente.getPf());
		cli.setPj(cliente.getPj());
		cli.setProjeto(cliente.getProjeto());
		cli.setTelefone(cliente.getTelefone());
		
		ClienteVo vo = DozerMapper.parseObjectForEntity(repository.save(cli), ClienteVo.class);
		vo.add(linkTo(methodOn(ClienteController.class).findById(cli.getId())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		Cliente cliente = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(cliente);
	}
}
