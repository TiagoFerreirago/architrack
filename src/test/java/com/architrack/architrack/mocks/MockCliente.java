package com.architrack.architrack.mocks;

import java.util.ArrayList;
import java.util.List;

import com.architrack.architrack.entities.Cliente;
import com.architrack.architrack.entities.PessoaFisica;
import com.architrack.architrack.entities.PessoaJuridica;
import com.architrack.architrack.entities.Projeto;
import com.architrack.architrack.entities.v1.vo.ClienteVo;

public class MockCliente {

	
	public Cliente mockCliente(int number) {
		Cliente cliente = new Cliente();
		
		cliente.setDocumentos(null);
		cliente.setEmail("gustavo@gmail.com");
		cliente.setEnderecos(null);
		cliente.setId((long)number);
		cliente.setNome("Gustavo Lima");
		cliente.setPf(new PessoaFisica("765321456-10","897456321-59",new Cliente()));
		cliente.setPj(null);
		cliente.setProjeto(new Projeto());
		cliente.setTelefone("81-123456789");
		return  cliente;
	}
	public ClienteVo mockClienteVo(int number) {
		ClienteVo vo = new ClienteVo();
		
		vo.setDocumentos(null);
		vo.setEmail("imobile@gmail.com");
		vo.setKey((long)number);
		vo.setNome("Cristine Gomes");
		vo.setEnderecos(null);
		vo.setPf(null);
		vo.setPj(new PessoaJuridica("12.345.678/0001-90", "123.456.789.123", null));
		vo.setProjeto(new Projeto());
		vo.setTelefone("18-987654321");
		return  vo;
	}
	
	public Cliente mockCliente() {
		return mockCliente(1);
	}
	
	public ClienteVo mockClienteVo() {
		return mockClienteVo(1);
	}
	
	public List<Cliente> mockListCliente(){
		List<Cliente>list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(mockCliente(i));
		}
		return list;
	}
	
	public List<ClienteVo> mockListClienteVo(){
		List<ClienteVo>vo = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			vo.add(mockClienteVo(i));
		}
		return vo;
	}
}
