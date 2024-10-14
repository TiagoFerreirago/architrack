package com.architrack.architrack.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Arquiteto;
import com.architrack.architrack.entities.v1.vo.ArquitetoVo;
import com.architrack.architrack.mocks.MockArquiteto;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestConverterMapperArquiteto {
	
	private MockArquiteto input;

	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockArquiteto();
		MockitoAnnotations.openMocks(this);
	}

	// validando a conversão entra entidadades através do Dozer
	@Test
	void testConverterArquitetoInVo(){
		ArquitetoVo arquitetoVo = DozerMapper.parseObjectForEntity(input.mockArquiteto(1),ArquitetoVo.class );
		
		assertNotNull(arquitetoVo);
		assertNotNull(arquitetoVo.getKey());
		assertNull(arquitetoVo.getEnderecos());
		assertNull(arquitetoVo.getProjetos());
		assertEquals("123@gmail.com",arquitetoVo.getEmail());
		assertEquals(1,arquitetoVo.getKey());
		assertEquals("Anna Green",arquitetoVo.getNome());
		assertEquals("123456789",arquitetoVo.getTelefone());
		assertEquals("Juridica",arquitetoVo.getTipo().getTipo());
		
	}
	
	@Test
	void testConverterVoInArquiteto(){
		Arquiteto arquiteto = DozerMapper.parseObjectForEntity(input.mockArquitetoVo(1),Arquiteto.class);
		
		assertNotNull(arquiteto);
		assertNotNull(arquiteto.getId());
		assertNull(arquiteto.getEnderecos());
		assertNull(arquiteto.getProjetos());
		assertEquals("987@gmail.com",arquiteto.getEmail());
		assertEquals(1,arquiteto.getId());
		assertEquals("Harry Kane",arquiteto.getNome());
		assertEquals("987654321",arquiteto.getTelefone());
		assertEquals("Juridica",arquiteto.getTipo().getTipo());
	}
	
	@Test
	void testConverterListArquitetoInVo(){
		List<ArquitetoVo> arquitetos = DozerMapper.parseListObjectForEntity(input.mockListArquiteto(),ArquitetoVo.class);
		
		ArquitetoVo vo = arquitetos.get(2);
		
		assertNotNull(vo);
		assertNotNull(vo.getKey());
		assertNull(vo.getEnderecos());
		assertNull(vo.getProjetos());
		assertEquals("123@gmail.com",vo.getEmail());
		assertEquals(2,vo.getKey());
		assertEquals("Anna Green",vo.getNome());
		assertEquals("123456789",vo.getTelefone());
		assertEquals("Juridica",vo.getTipo().getTipo());
		
		ArquitetoVo voFive = arquitetos.get(5);
		
		assertNotNull(voFive);
		assertNotNull(voFive.getKey());
		assertNull(voFive.getEnderecos());
		assertNull(voFive.getProjetos());
		assertEquals("123@gmail.com",voFive.getEmail());
		assertEquals(5,voFive.getKey());
		assertEquals("Anna Green",voFive.getNome());
		assertEquals("123456789",voFive.getTelefone());
		assertEquals("Juridica",voFive.getTipo().getTipo());
		
		ArquitetoVo voEight = arquitetos.get(8);
		
		assertNotNull(voEight);
		assertNotNull(voEight.getKey());
		assertNull(voEight.getEnderecos());
		assertNull(voEight.getProjetos());
		assertEquals("123@gmail.com",voEight.getEmail());
		assertEquals(8,voEight.getKey());
		assertEquals("Anna Green",voEight.getNome());
		assertEquals("123456789",voEight.getTelefone());
		assertEquals("Juridica",voEight.getTipo().getTipo());
	}
	@Test
	void testConverterListVoInArquiteto(){
		List<Arquiteto> arquitetos = DozerMapper.parseListObjectForEntity(input.mockListArquitetoVo(), Arquiteto.class);
		
		Arquiteto arq = arquitetos.get(1);
		
		assertNotNull(arq);
		assertNotNull(arq.getId());
		assertNull(arq.getEnderecos());
		assertNull(arq.getProjetos());
		assertEquals("987@gmail.com",arq.getEmail());
		assertEquals(1,arq.getId());
		assertEquals("Harry Kane",arq.getNome());
		assertEquals("987654321",arq.getTelefone());
		assertEquals("Juridica",arq.getTipo().getTipo());
		
		Arquiteto arqThree = arquitetos.get(3);
		
		assertNotNull(arqThree);
		assertNotNull(arqThree.getId());
		assertNull(arqThree.getEnderecos());
		assertNull(arqThree.getProjetos());
		assertEquals("987@gmail.com",arqThree.getEmail());
		assertEquals(3,arqThree.getId());
		assertEquals("Harry Kane",arqThree.getNome());
		assertEquals("987654321",arqThree.getTelefone());
		assertEquals("Juridica",arqThree.getTipo().getTipo());
		
		Arquiteto arqSix = arquitetos.get(6);
		
		assertNotNull(arqSix);
		assertNotNull(arqSix.getId());
		assertNull(arqSix.getEnderecos());
		assertNull(arqSix.getProjetos());
		assertEquals("987@gmail.com",arqSix.getEmail());
		assertEquals(6,arqSix.getId());
		assertEquals("Harry Kane",arqSix.getNome());
		assertEquals("987654321",arqSix.getTelefone());
		assertEquals("Juridica",arqSix.getTipo().getTipo());
	}
	
	

}
