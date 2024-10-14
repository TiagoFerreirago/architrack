package com.architrack.architrack.mocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.architrack.architrack.entities.Agenda;
import com.architrack.architrack.entities.Projeto;
import com.architrack.architrack.entities.v1.vo.AgendaVo;

public class MockAgenda {

	
	public Agenda mockAgenda() throws ParseException {
		return mockAgenda(1);
	}
	public AgendaVo mockAgendaVo() throws ParseException {
		return mockAgendaVo(1);
	}
	
	public AgendaVo mockAgendaVo(int i) throws ParseException {
		AgendaVo vo = new AgendaVo();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		vo.setKey((long)i);
		vo.setDataFim(format.parse("25/10/2024"));
		vo.setDataInicio(format.parse("20/10/2024"));
		vo.setProjeto(new Projeto());
		return vo;
	}

	public Agenda mockAgenda(int i) throws ParseException {
		Agenda vo = new Agenda();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		vo.setId((long)i);
		vo.setDataFim(format.parse("15/10/2024"));
		vo.setDataInicio(format.parse("12/10/2024"));
		vo.setProjeto(new Projeto());
		return vo;
	}
	
	public List<Agenda> mockListAgenda() throws ParseException{
		List<Agenda>list = new ArrayList<Agenda>();
		for (int i = 0; i < 10; i++) {		
			list.add(mockAgenda(i));
		}
		return list;
	}
	public List<AgendaVo> mockListAgendaVo() throws ParseException{
		List<AgendaVo>list = new ArrayList<AgendaVo>();
		for (int i = 0; i < 10; i++) {
			list.add(mockAgendaVo(i));
		}
		return list;
	}
	
	
	
}
