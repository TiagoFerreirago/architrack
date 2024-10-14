package com.architrack.architrack.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Agenda;
import com.architrack.architrack.entities.v1.vo.AgendaVo;
import com.architrack.architrack.mocks.MockAgenda;
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestConverterMapperAgenda {
	
	private MockAgenda input;
	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockAgenda();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void converterAgendaInVo() throws ParseException {
		AgendaVo agd = DozerMapper.parseObjectForEntity(input.mockAgenda(1), AgendaVo.class);
		assertNotNull(agd.getKey());
		assertEquals(1,agd.getKey());
		assertEquals("Sat Oct 12 00:00:00 BRT 2024",agd.getDataInicio().toString());
		assertEquals("Tue Oct 15 00:00:00 BRT 2024",agd.getDataFim().toString());
	}
	
	@Test
	void testConverterVoInAgenda() throws ParseException {
		Agenda agd = DozerMapper.parseObjectForEntity(input.mockAgendaVo(1),Agenda.class);
		
		assertNotNull(agd);
		assertEquals(1,agd.getId());
		assertEquals("Sun Oct 20 00:00:00 BRT 2024",agd.getDataInicio().toString());
		assertEquals("Fri Oct 25 00:00:00 BRT 2024",agd.getDataFim().toString());
	}
	@Test
	void testConverterListAgendaInVo() throws ParseException {
		
		List<AgendaVo> list = DozerMapper.parseListObjectForEntity(input.mockListAgenda(), AgendaVo.class);
		
		AgendaVo vo = list.get(2);
		
		assertNotNull(vo);
		assertNotNull(vo.getKey());
		assertEquals(2,vo.getKey());
		assertEquals("Sat Oct 12 00:00:00 BRT 2024",vo.getDataInicio().toString());
		assertEquals("Tue Oct 15 00:00:00 BRT 2024",vo.getDataFim().toString());
		
		AgendaVo voFive = list.get(5);
		
		assertNotNull(voFive);
		assertNotNull(voFive.getKey());
		assertEquals(5,voFive.getKey());
		assertEquals("Sat Oct 12 00:00:00 BRT 2024",vo.getDataInicio().toString());
		assertEquals("Tue Oct 15 00:00:00 BRT 2024",vo.getDataFim().toString());
		
		AgendaVo voSeven = list.get(7);
		
		assertNotNull(voSeven);
		assertNotNull(voSeven.getKey());
		assertEquals(7,voSeven.getKey());
		assertEquals("Sat Oct 12 00:00:00 BRT 2024",vo.getDataInicio().toString());
		assertEquals("Tue Oct 15 00:00:00 BRT 2024",vo.getDataFim().toString());
	}
	@Test
	void testConverterListVoInAgenda() throws ParseException {
		
		List<Agenda> list = DozerMapper.parseListObjectForEntity(input.mockListAgendaVo(), Agenda.class);
		
		Agenda agd= list.get(1);
		
		assertNotNull(agd);
		assertNotNull(agd.getId());
		assertEquals(1,agd.getId());
		assertEquals("Sun Oct 20 00:00:00 BRT 2024",agd.getDataInicio().toString());
		assertEquals("Fri Oct 25 00:00:00 BRT 2024",agd.getDataFim().toString());
		
		Agenda agdFour = list.get(4);
		
		assertNotNull(agdFour);
		assertNotNull(agdFour.getId());
		assertEquals(4,agdFour.getId());
		assertEquals("Sun Oct 20 00:00:00 BRT 2024",agdFour.getDataInicio().toString());
		assertEquals("Fri Oct 25 00:00:00 BRT 2024",agdFour.getDataFim().toString());
		
		Agenda agdEight = list.get(8);
		
		assertNotNull(agdEight);
		assertNotNull(agdEight.getId());
		assertEquals(8,agdEight.getId());
		assertEquals("Sun Oct 20 00:00:00 BRT 2024",agdEight.getDataInicio().toString());
		assertEquals("Fri Oct 25 00:00:00 BRT 2024",agdEight.getDataFim().toString());
	}

}
