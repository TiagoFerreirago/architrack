package com.architrack.architrack.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Projeto;
import com.architrack.architrack.entities.v1.vo.ProjetoVo;
import com.architrack.architrack.mocks.MockProjeto;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestConverterMapperProjeto {
	
	private MockProjeto input;

	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockProjeto();
		MockitoAnnotations.openMocks(this);
	}

	// validando a conversão entra entidadades através do Dozer
	@Test
	void testConverterProjetosInVo(){
		ProjetoVo projetosVo = DozerMapper.parseObjectForEntity(input.mockProjeto(1), ProjetoVo.class);
		
		assertNotNull(projetosVo.getKey());
		assertNotNull(projetosVo.getCliente());
		assertNull(projetosVo.getAgendamentos());
		assertNull(projetosVo.getArquitetos());
		assertNull(projetosVo.getDocumentos());
		assertNull(projetosVo.getListaHistorico());
		assertNull(projetosVo.getPagamentos());
		assertEquals(1, projetosVo.getKey());
		assertEquals("Construção civil", projetosVo.getAreaEmpreendimento());
		
		
	}
	
	@Test
	void testConverterVoInProjetos(){
		Projeto projetos = DozerMapper.parseObjectForEntity(input.mockProjetoVo(), Projeto.class);
		
		assertNotNull(projetos.getId());
		assertNotNull(projetos.getCliente());
		assertNull(projetos.getAgendamentos());
		assertNull(projetos.getArquitetos());
		assertNull(projetos.getDocumentos());
		assertNull(projetos.getListaHistorico());
		assertNull(projetos.getPagamentos());
		assertEquals(1, projetos.getId());
		assertEquals("Construção civil", projetos.getAreaEmpreendimento());
	}
	
	@Test
	void testConverterListProjetosInVo(){
		List<ProjetoVo> projetos = DozerMapper.parseListObjectForEntity(input.mockListProjeto(),ProjetoVo.class);
		
		ProjetoVo projetoTwo = projetos.get(2);
		
		assertNotNull(projetoTwo.getKey());
		assertNotNull(projetoTwo.getCliente());
		assertNull(projetoTwo.getAgendamentos());
		assertNull(projetoTwo.getArquitetos());
		assertNull(projetoTwo.getDocumentos());
		assertNull(projetoTwo.getListaHistorico());
		assertNull(projetoTwo.getPagamentos());
		assertEquals(2, projetoTwo.getKey());
		assertEquals("Construção civil", projetoTwo.getAreaEmpreendimento());
		
		ProjetoVo projetoFive = projetos.get(5);
		
		assertNotNull(projetoFive.getKey());
		assertNotNull(projetoFive.getCliente());
		assertNull(projetoFive.getAgendamentos());
		assertNull(projetoFive.getArquitetos());
		assertNull(projetoFive.getDocumentos());
		assertNull(projetoFive.getListaHistorico());
		assertNull(projetoFive.getPagamentos());
		assertEquals(5, projetoFive.getKey());
		assertEquals("Construção civil", projetoFive.getAreaEmpreendimento());
		
		ProjetoVo projetoNine = projetos.get(9);
		
		assertNotNull(projetoNine.getKey());
		assertNotNull(projetoNine.getCliente());
		assertNull(projetoNine.getAgendamentos());
		assertNull(projetoNine.getArquitetos());
		assertNull(projetoNine.getDocumentos());
		assertNull(projetoNine.getListaHistorico());
		assertNull(projetoNine.getPagamentos());
		assertEquals(9, projetoNine.getKey());
		assertEquals("Construção civil", projetoNine.getAreaEmpreendimento());
	}
	@Test
	void testConverterListVoInProjetos(){
		List<Projeto> projetos = DozerMapper.parseListObjectForEntity(input.mockListProjetoVo(),Projeto.class);
		
		Projeto projetoThree = projetos.get(3);

		assertNotNull(projetoThree.getId());
		assertNotNull(projetoThree.getCliente());
		assertNull(projetoThree.getAgendamentos());
		assertNull(projetoThree.getArquitetos());
		assertNull(projetoThree.getDocumentos());
		assertNull(projetoThree.getListaHistorico());
		assertNull(projetoThree.getPagamentos());
		assertEquals(3, projetoThree.getId());
		assertEquals("Construção civil", projetoThree.getAreaEmpreendimento());
		
		Projeto projetoFour = projetos.get(4);
		
		assertNotNull(projetoFour.getId());
		assertNotNull(projetoFour.getCliente());
		assertNull(projetoFour.getAgendamentos());
		assertNull(projetoFour.getArquitetos());
		assertNull(projetoFour.getDocumentos());
		assertNull(projetoFour.getListaHistorico());
		assertNull(projetoFour.getPagamentos());
		assertEquals(4, projetoFour.getId());
		assertEquals("Construção civil", projetoFour.getAreaEmpreendimento());
		
		Projeto projetoSeven = projetos.get(7);
		
		assertNotNull(projetoSeven.getId());
		assertNotNull(projetoSeven.getCliente());
		assertNull(projetoSeven.getAgendamentos());
		assertNull(projetoSeven.getArquitetos());
		assertNull(projetoSeven.getDocumentos());
		assertNull(projetoSeven.getListaHistorico());
		assertNull(projetoSeven.getPagamentos());
		assertEquals(7, projetoSeven.getId());
		assertEquals("Construção civil", projetoSeven.getAreaEmpreendimento());
	}
	
	

}
