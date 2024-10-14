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
import com.architrack.architrack.entities.Historico;
import com.architrack.architrack.entities.v1.vo.HistoricoVo;
import com.architrack.architrack.mocks.MockHistorico;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestConverterMapperHistorico {
	
	private MockHistorico input;

	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockHistorico();
		MockitoAnnotations.openMocks(this);
	}

	// validando a conversão entra entidadades através do Dozer
	@Test
	void testConverterHistoricoInVo() throws ParseException{
		HistoricoVo historicoVo = DozerMapper.parseObjectForEntity(input.mockHistorico(1),HistoricoVo.class );
		
		assertNotNull(historicoVo);
		assertNotNull(historicoVo.getKey());
		assertNotNull(historicoVo.getProjeto());
		assertEquals(1,historicoVo.getKey());
		assertEquals("Sun Dec 15 00:00:00 BRT 2024",historicoVo.getDataMudanca().toString());
		assertEquals("Atraso de Matérial",historicoVo.getDescricaoMudanca());	
		
	}
	
	@Test
	void testConverterVoInHistorico() throws Throwable{
		Historico historico = DozerMapper.parseObjectForEntity(input.mockHistoricoVo(1),Historico.class);
		
		assertNotNull(historico);
		assertNotNull(historico.getId());
		assertNotNull(historico.getProjeto());
		assertEquals(1,historico.getId());
		assertEquals("Wed Dec 25 00:00:00 BRT 2024",historico.getDataMudanca().toString());
		assertEquals("Licença",historico.getDescricaoMudanca());	
	}
	
	@Test
	void testConverterListHistoricoInVo() throws Throwable{
		List<HistoricoVo> historicosVo = DozerMapper.parseListObjectForEntity(input.mockListHistorico(),HistoricoVo.class);
		
		HistoricoVo voTwo = historicosVo.get(2);
		
		assertNotNull(voTwo);
		assertNotNull(voTwo.getKey());
		assertNotNull(voTwo.getProjeto());
		assertEquals(2,voTwo.getKey());
		assertEquals("Sun Dec 15 00:00:00 BRT 2024",voTwo.getDataMudanca().toString());
		assertEquals("Atraso de Matérial",voTwo.getDescricaoMudanca());	
		
		HistoricoVo voFive = historicosVo.get(5);
		
		assertNotNull(voFive);
		assertNotNull(voFive.getKey());
		assertNotNull(voFive.getProjeto());
		assertEquals(5,voFive.getKey());
		assertEquals("Sun Dec 15 00:00:00 BRT 2024",voFive.getDataMudanca().toString());
		assertEquals("Atraso de Matérial",voFive.getDescricaoMudanca());	
		
		HistoricoVo voEight = historicosVo.get(8);
		
		assertNotNull(voEight);
		assertNotNull(voEight.getKey());
		assertNotNull(voEight.getProjeto());
		assertEquals(8,voEight.getKey());
		assertEquals("Sun Dec 15 00:00:00 BRT 2024",voEight.getDataMudanca().toString());
		assertEquals("Atraso de Matérial",voEight.getDescricaoMudanca());	
		
	}
	@Test
	void testConverterListVoInHistorico() throws Throwable{
		List<Historico> historicos = DozerMapper.parseListObjectForEntity(input.mockListHistoricoVo(), Historico.class);
		
		Historico historico = historicos.get(1);
		
		assertNotNull(historico);
		assertNotNull(historico.getId());
		assertNotNull(historico.getProjeto());
		assertEquals(1,historico.getId());
		assertEquals("Wed Dec 25 00:00:00 BRT 2024",historico.getDataMudanca().toString());
		assertEquals("Licença",historico.getDescricaoMudanca());
		
		Historico historicoThree = historicos.get(3);
		
		assertNotNull(historicoThree);
		assertNotNull(historicoThree.getId());
		assertNotNull(historicoThree.getProjeto());
		assertEquals(3,historicoThree.getId());
		assertEquals("Wed Dec 25 00:00:00 BRT 2024",historicoThree.getDataMudanca().toString());
		assertEquals("Licença",historicoThree.getDescricaoMudanca());
		
		Historico historicoSix = historicos.get(6);
		
		assertNotNull(historicoSix);
		assertNotNull(historicoSix.getId());
		assertNotNull(historicoSix.getProjeto());
		assertEquals(6,historicoSix.getId());
		assertEquals("Wed Dec 25 00:00:00 BRT 2024",historicoSix.getDataMudanca().toString());
		assertEquals("Licença",historicoSix.getDescricaoMudanca());
	}
	
	

}
