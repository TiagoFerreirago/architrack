package com.architrack.architrack.mocks;

import java.util.ArrayList;
import java.util.List;

import com.architrack.architrack.entities.Cliente;
import com.architrack.architrack.entities.Projeto;
import com.architrack.architrack.entities.v1.vo.ProjetoVo;

public class MockProjeto {

	public Projeto mockProjeto(int number) {
		Projeto projeto = new Projeto();
		
		projeto.setAgendamentos(null);
		projeto.setAreaEmpreendimento("Construção civil");
		projeto.setArquitetos(null);
		projeto.setCliente(new Cliente());
		projeto.setDocumentos(null);
		projeto.setId((long)number);
		projeto.setListaHistorico(null);
		projeto.setPagamentos(null);
		return projeto;
	}
	
	public ProjetoVo mockProjetoVo(int number) {
		ProjetoVo projetoVo = new ProjetoVo();
		
		projetoVo.setAgendamentos(null);
		projetoVo.setAreaEmpreendimento("Construção civil");
		projetoVo.setArquitetos(null);
		projetoVo.setCliente(new Cliente());
		projetoVo.setDocumentos(null);
		projetoVo.setKey((long)number);
		projetoVo.setListaHistorico(null);
		projetoVo.setPagamentos(null);
		return projetoVo;
	}
	
	public Projeto mockProjeto() {
		return mockProjeto(1);
		
	}
	
	public ProjetoVo mockProjetoVo() {
		return mockProjetoVo(1);
		
	}
	
	public List<Projeto> mockListProjeto(){
		List<Projeto> projetos = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			projetos.add(mockProjeto(i));
		}
		return projetos;
	}
	
	public List<ProjetoVo> mockListProjetoVo(){
		List<ProjetoVo> projetosVo = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			projetosVo.add(mockProjetoVo(i));
		}
		return projetosVo;
	}
}
