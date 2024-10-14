package com.architrack.architrack.mocks;

import java.util.ArrayList;
import java.util.List;

import com.architrack.architrack.entities.Arquiteto;
import com.architrack.architrack.entities.TipoPessoa;
import com.architrack.architrack.entities.v1.vo.ArquitetoVo;

public class MockArquiteto {

	
	public Arquiteto mockArquiteto(int number) {
		Arquiteto arq = new Arquiteto();
		TipoPessoa juridica = new TipoPessoa("Juridica",new Arquiteto());
		arq.setEmail("123@gmail.com");
		arq.setEnderecos(null);
		arq.setId((long)number);
		arq.setNome("Anna Green");
		arq.setProjetos(null);
		arq.setTelefone("123456789");
		arq.setTipo(juridica);
		return arq;
	}
	public ArquitetoVo mockArquitetoVo(int number) {
		ArquitetoVo vo = new ArquitetoVo();
		TipoPessoa juridica = new TipoPessoa("Juridica",new Arquiteto());
		vo.setEmail("987@gmail.com");
		vo.setEnderecos(null);
		vo.setKey((long)number);
		vo.setNome("Harry Kane");
		vo.setProjetos(null);
		vo.setTelefone("987654321");
		vo.setTipo(juridica);
		return vo;
	}
	
	public Arquiteto mockArquiteto() {
		return mockArquiteto(1);
	}
	
	public ArquitetoVo mockArquitetoVo() {
		return mockArquitetoVo(1);
	}
	
	public List<Arquiteto>mockListArquiteto(){
		List<Arquiteto> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(mockArquiteto(i));
		}
		return list;
	}
	public List<ArquitetoVo>mockListArquitetoVo(){
		List<ArquitetoVo> vo = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			vo.add(mockArquitetoVo(i));
		}
		return vo;
	}
}
