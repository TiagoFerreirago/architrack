package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Cliente;
import com.architrack.architrack.entities.v1.vo.ClienteVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	private  ClienteRepository repository;
	
	private DozerMapper mapper;


	public ClienteVo findById(Long id) {
		Cliente cliente = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		ClienteVo vo = mapper.parseObjectForEntity(cliente, ClienteVo.class);
		return vo;
		
	}
	
	public List<ClienteVo> findAll() {
		List<Cliente>cliente = repository.findAll();
		List<ClienteVo>listVo = mapper.parseListObjectForEntity(cliente, ClienteVo.class);
		return listVo;
	}
	
	public ClienteVo create(ClienteVo cliente) {
		Cliente cli = mapper.parseObjectForEntity(cliente, Cliente.class);
		ClienteVo vo = mapper.parseObjectForEntity(repository.save(cli), ClienteVo.class);
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
		
		ClienteVo vo = mapper.parseObjectForEntity(repository.save(cli), ClienteVo.class);
		return vo;
	}
	
	public void delete(Long id) {
		Cliente cliente = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(cliente);
	}
}
