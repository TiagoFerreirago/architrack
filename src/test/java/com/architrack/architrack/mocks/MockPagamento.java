package com.architrack.architrack.mocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.architrack.architrack.entities.Pagamentos;
import com.architrack.architrack.entities.Projeto;
import com.architrack.architrack.entities.v1.vo.PagamentosVo;

public class MockPagamento {

	
	public Pagamentos mockPagamentos(int number) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Pagamentos pagamentos = new Pagamentos();
		
		pagamentos.setDataPagamento(format.parse("08/11/2024"));
		pagamentos.setId((long)number);
		pagamentos.setProjeto(new Projeto());
		pagamentos.setStatus("Concluido");
		pagamentos.setValor(54000.00);
		return pagamentos;
	}
	
	public PagamentosVo mockPagamentosVo(int number) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		PagamentosVo vo = new PagamentosVo();
		
		vo.setDataPagamento(format.parse("18/10/2024"));
		vo.setKey((long)number);
		vo.setProjeto(new Projeto());
		vo.setStatus("Aguardando");
		vo.setValor(78000.00);
		return vo;
	}
	
	public Pagamentos mockPagamentos() throws ParseException {
		
		return mockPagamentos(1);
	}
	
	public PagamentosVo mockPagamentosVo() throws ParseException {
		
		return mockPagamentosVo(1);
	}
	
	public List<Pagamentos> mockListPagamentos() throws ParseException{
		List<Pagamentos> pagamentos = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			pagamentos.add(mockPagamentos(i));
		}
		return pagamentos;
	}
	
	public List<PagamentosVo> mockListPagamentosVo() throws ParseException{
		List<PagamentosVo> pagamentosVo = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			pagamentosVo.add(mockPagamentosVo(i));
		}
		return pagamentosVo;
	}
}
