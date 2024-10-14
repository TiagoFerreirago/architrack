package com.architrack.architrack.mocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.architrack.architrack.entities.Historico;
import com.architrack.architrack.entities.Projeto;
import com.architrack.architrack.entities.v1.vo.HistoricoVo;

public class MockHistorico {

	
	public Historico mockHistorico(int number) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Historico historico = new Historico();
		historico.setDataMudanca(format.parse("15/12/2024"));
		historico.setDescricaoMudanca("Atraso de Matérial");
		historico.setId((long)number);
		historico.setProjeto(new Projeto());
		return historico;
	}
	
	public HistoricoVo mockHistoricoVo(int number) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		HistoricoVo vo = new HistoricoVo();
		vo.setDataMudanca(format.parse("25/12/2024"));
		vo.setDescricaoMudanca("Licença");
		vo.setKey((long)number);
		vo.setProjeto(new Projeto());
		return vo;
	}
	
	public Historico mockHistorico() throws ParseException {
		return mockHistorico(1);
		
	}
	
	public HistoricoVo mockHistoricoVo() throws ParseException {
		return mockHistoricoVo(1);
		
	}
	
	public List<Historico> mockListHistorico() throws ParseException{
		List<Historico>list = new ArrayList<>();
		
		for(int i = 0 ; i < 10; i++) {
			list.add(mockHistorico(i));
		}
		return list;
	}
	
	public List<HistoricoVo> mockListHistoricoVo() throws ParseException{
		List<HistoricoVo>vo = new ArrayList<>();
		
		for(int i = 0 ; i < 10; i++) {
			vo.add(mockHistoricoVo(i));
		}
		return vo;
	}
}
