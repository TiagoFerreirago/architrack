package com.architrack.architrack.mocks;

import java.util.ArrayList;
import java.util.List;

import com.architrack.architrack.entities.Arquiteto;
import com.architrack.architrack.entities.Cliente;
import com.architrack.architrack.entities.Endereco;
import com.architrack.architrack.entities.v1.vo.EnderecoVo;

public class MockEndereco {

	public Endereco mockEndereco(int number) {
		
		Endereco endereco = new Endereco();
		endereco.setArquiteto(new Arquiteto());
		endereco.setBairro("Marilia");
		endereco.setCep("41235-415");
		endereco.setCidade("São Bernado");
		endereco.setCliente(new Cliente());
		endereco.setEstado("SP");
		endereco.setId((long)number);
		endereco.setRua("Rua das Neves");
		return endereco;
	}
	
	public EnderecoVo mockEnderecoVo(int number) {
		
		EnderecoVo vo = new EnderecoVo();
		vo.setArquiteto(new Arquiteto());
		vo.setBairro("Pituba");
		vo.setCep("41830-480");
		vo.setCidade("Salvador");
		vo.setCliente(new Cliente());
		vo.setEstado("BA");
		vo.setKey((long)number);
		vo.setRua("Rua Ceará");
		return vo;
	}
	
	public Endereco mockEndereco() {
		return mockEndereco(1);
		
	}
	
	public EnderecoVo mockEnderecoVo() {
		return mockEnderecoVo(1);
		
	}
	
	public List<Endereco> mockListEndereco(){
		List<Endereco>list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(mockEndereco(i));
		}
		return list;
	}
	
	public List<EnderecoVo> mockListEnderecoVo(){
		List<EnderecoVo>vo = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			vo.add(mockEnderecoVo(i));
		}
		return vo;
	}
	
}
