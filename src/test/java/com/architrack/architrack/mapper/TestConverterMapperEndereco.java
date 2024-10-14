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
import com.architrack.architrack.entities.Endereco;
import com.architrack.architrack.entities.v1.vo.EnderecoVo;
import com.architrack.architrack.mocks.MockEndereco;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestConverterMapperEndereco {
	
	private MockEndereco input;

	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockEndereco();
		MockitoAnnotations.openMocks(this);
	}

	// validando a conversão entra entidadades através do Dozer
	@Test
	void testConverterEnderecoInVo() throws ParseException{
		EnderecoVo enderecoVo = DozerMapper.parseObjectForEntity(input.mockEndereco(1),EnderecoVo.class );
		
		assertNotNull(enderecoVo);
		assertNotNull(enderecoVo.getKey());
		assertNotNull(enderecoVo.getArquiteto());
		assertNotNull(enderecoVo.getCliente());
		assertEquals("Marilia",enderecoVo.getBairro());
		assertEquals(1,enderecoVo.getKey());
		assertEquals("41235-415",enderecoVo.getCep());
		assertEquals("São Bernado",enderecoVo.getCidade());	
		assertEquals("SP",enderecoVo.getEstado());	
		assertEquals("Rua das Neves",enderecoVo.getRua());	
		
	}
	
	@Test
	void testConverterVoInEndereco(){
		Endereco endereco = DozerMapper.parseObjectForEntity(input.mockEnderecoVo(1),Endereco.class);
		
		assertNotNull(endereco);
		assertNotNull(endereco.getId());
		assertNotNull(endereco.getArquiteto());
		assertNotNull(endereco.getCliente());
		assertEquals("Pituba",endereco.getBairro());
		assertEquals(1,endereco.getId());
		assertEquals("41830-480",endereco.getCep());
		assertEquals("Salvador",endereco.getCidade());	
		assertEquals("BA",endereco.getEstado());	
		assertEquals("Rua Ceará",endereco.getRua());	
	}
	
	@Test
	void testConverterListEnderecoInVo(){
		List<EnderecoVo> enderecosVo = DozerMapper.parseListObjectForEntity(input.mockListEndereco(),EnderecoVo.class);
		
		EnderecoVo voTwo = enderecosVo.get(2);
		
		assertNotNull(voTwo);
		assertNotNull(voTwo.getKey());
		assertNotNull(voTwo.getArquiteto());
		assertNotNull(voTwo.getCliente());
		assertEquals("Marilia",voTwo.getBairro());
		assertEquals(2,voTwo.getKey());
		assertEquals("41235-415",voTwo.getCep());
		assertEquals("São Bernado",voTwo.getCidade());	
		assertEquals("SP",voTwo.getEstado());	
		assertEquals("Rua das Neves",voTwo.getRua());	
		
		EnderecoVo voFive = enderecosVo.get(5);
		
		assertNotNull(voFive);
		assertNotNull(voFive.getKey());
		assertNotNull(voFive.getArquiteto());
		assertNotNull(voFive.getCliente());
		assertEquals("Marilia",voFive.getBairro());
		assertEquals(5,voFive.getKey());
		assertEquals("41235-415",voFive.getCep());
		assertEquals("São Bernado",voFive.getCidade());	
		assertEquals("SP",voFive.getEstado());	
		assertEquals("Rua das Neves",voFive.getRua());
		
		EnderecoVo voEight = enderecosVo.get(8);
		
		assertNotNull(voEight );
		assertNotNull(voEight .getKey());
		assertNotNull(voEight .getArquiteto());
		assertNotNull(voEight .getCliente());
		assertEquals("Marilia",voEight .getBairro());
		assertEquals(8,voEight .getKey());
		assertEquals("41235-415",voEight .getCep());
		assertEquals("São Bernado",voEight .getCidade());	
		assertEquals("SP",voEight .getEstado());	
		assertEquals("Rua das Neves",voEight.getRua());
	}
	@Test
	void testConverterListVoInEndereco(){
		List<Endereco> enderecos = DozerMapper.parseListObjectForEntity(input.mockListEnderecoVo(), Endereco.class);
		
		Endereco endereco = enderecos.get(1);
		
		assertNotNull(endereco);
		assertNotNull(endereco.getId());
		assertNotNull(endereco.getArquiteto());
		assertNotNull(endereco.getCliente());
		assertEquals("Pituba",endereco.getBairro());
		assertEquals(1,endereco.getId());
		assertEquals("41830-480",endereco.getCep());
		assertEquals("Salvador",endereco.getCidade());	
		assertEquals("BA",endereco.getEstado());	
		assertEquals("Rua Ceará",endereco.getRua());
		
		Endereco enderecoThree = enderecos.get(3);
		
		assertNotNull(enderecoThree);
		assertNotNull(enderecoThree.getId());
		assertNotNull(enderecoThree.getArquiteto());
		assertNotNull(enderecoThree.getCliente());
		assertEquals("Pituba",enderecoThree.getBairro());
		assertEquals(3,enderecoThree.getId());
		assertEquals("41830-480",enderecoThree.getCep());
		assertEquals("Salvador",enderecoThree.getCidade());	
		assertEquals("BA",enderecoThree.getEstado());	
		assertEquals("Rua Ceará",enderecoThree.getRua());
		
		Endereco enderecoSix = enderecos.get(6);
		
		assertNotNull(enderecoSix);
		assertNotNull(enderecoSix.getId());
		assertNotNull(enderecoSix.getArquiteto());
		assertNotNull(enderecoSix.getCliente());
		assertEquals("Pituba",enderecoSix.getBairro());
		assertEquals(6,enderecoSix.getId());
		assertEquals("41830-480",enderecoSix.getCep());
		assertEquals("Salvador",enderecoSix.getCidade());	
		assertEquals("BA",enderecoSix.getEstado());	
		assertEquals("Rua Ceará",enderecoSix.getRua());
	}
	
	

}
