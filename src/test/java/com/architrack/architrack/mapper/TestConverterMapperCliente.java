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
import com.architrack.architrack.entities.Cliente;
import com.architrack.architrack.entities.v1.vo.ClienteVo;
import com.architrack.architrack.mocks.MockCliente;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestConverterMapperCliente {
	
	private MockCliente input;

	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockCliente();
		MockitoAnnotations.openMocks(this);
	}

	// validando a conversão entra entidadades através do Dozer
	@Test
	void testConverterClienteInVo(){
		ClienteVo clienteVo = DozerMapper.parseObjectForEntity(input.mockCliente(1),ClienteVo.class );
		
		assertNotNull(clienteVo);
		assertNotNull(clienteVo.getKey());
		assertNotNull(clienteVo.getProjeto());
		assertNull(clienteVo.getEnderecos());
		assertNull(clienteVo.getPj());
		assertEquals("gustavo@gmail.com",clienteVo.getEmail());
		assertEquals(1,clienteVo.getKey());
		assertEquals("Gustavo Lima",clienteVo.getNome());
		assertEquals("81-123456789",clienteVo.getTelefone());
		assertEquals("765321456-10",clienteVo.getPf().getRg());
		assertEquals("897456321-59",clienteVo.getPf().getCpf());
		
	}
	
	@Test
	void testConverterVoInCliente(){
		Cliente cliente = DozerMapper.parseObjectForEntity(input.mockClienteVo(1),Cliente.class);
		
		assertNotNull(cliente);
		assertNotNull(cliente.getId());
		assertNotNull(cliente.getProjeto());
		assertNull(cliente.getEnderecos());
		assertNull(cliente.getPf());
		assertEquals("imobile@gmail.com",cliente.getEmail());
		assertEquals(1,cliente.getId());
		assertEquals("Cristine Gomes",cliente.getNome());
		assertEquals("18-987654321",cliente.getTelefone());
		assertEquals("12.345.678/0001-90",cliente.getPj().getCnpj());
		assertEquals("123.456.789.123",cliente.getPj().getInscricaoEstadual());
	}
	
	@Test
	void testConverterListClienteInVo(){
		List<ClienteVo> clientesVo = DozerMapper.parseListObjectForEntity(input.mockListCliente(),ClienteVo.class);
		
		ClienteVo vo = clientesVo.get(2);
		
		assertNotNull(vo);
		assertNotNull(vo.getKey());
		assertNotNull(vo.getProjeto());
		assertNull(vo.getEnderecos());
		assertNull(vo.getPj());
		assertEquals("gustavo@gmail.com",vo.getEmail());
		assertEquals(2,vo.getKey());
		assertEquals("Gustavo Lima",vo.getNome());
		assertEquals("81-123456789",vo.getTelefone());
		assertEquals("765321456-10",vo.getPf().getRg());
		assertEquals("897456321-59",vo.getPf().getCpf());
		
		ClienteVo voFive = clientesVo.get(5);
		
		assertNotNull(voFive);
		assertNotNull(voFive.getKey());
		assertNotNull(voFive.getProjeto());
		assertNull(voFive.getEnderecos());
		assertNull(voFive.getPj());
		assertEquals("gustavo@gmail.com",voFive.getEmail());
		assertEquals(5,voFive.getKey());
		assertEquals("Gustavo Lima",voFive.getNome());
		assertEquals("81-123456789",voFive.getTelefone());
		assertEquals("765321456-10",voFive.getPf().getRg());
		assertEquals("897456321-59",voFive.getPf().getCpf());
		
		ClienteVo voEight = clientesVo.get(8);
		
		assertNotNull(voEight);
		assertNotNull(voEight.getKey());
		assertNotNull(voEight.getProjeto());
		assertNull(voEight.getEnderecos());
		assertNull(voEight.getPj());
		assertEquals("gustavo@gmail.com",voEight.getEmail());
		assertEquals(8,voEight.getKey());
		assertEquals("Gustavo Lima",voEight.getNome());
		assertEquals("81-123456789",voEight.getTelefone());
		assertEquals("765321456-10",voEight.getPf().getRg());
		assertEquals("897456321-59",voEight.getPf().getCpf());
	}
	@Test
	void testConverterListVoInCliente(){
		List<Cliente> clientes = DozerMapper.parseListObjectForEntity(input.mockListClienteVo(), Cliente.class);
		
		Cliente cliente = clientes.get(1);
		
		assertNotNull(cliente);
		assertNotNull(cliente.getId());
		assertNotNull(cliente.getProjeto());
		assertNull(cliente.getEnderecos());
		assertNull(cliente.getPf());
		assertEquals("imobile@gmail.com",cliente.getEmail());
		assertEquals(1,cliente.getId());
		assertEquals("Cristine Gomes",cliente.getNome());
		assertEquals("18-987654321",cliente.getTelefone());
		assertEquals("12.345.678/0001-90",cliente.getPj().getCnpj());
		assertEquals("123.456.789.123",cliente.getPj().getInscricaoEstadual());
		
		Cliente clienteThree = clientes.get(3);
		
		assertNotNull(clienteThree);
		assertNotNull(clienteThree.getId());
		assertNotNull(clienteThree.getProjeto());
		assertNull(clienteThree.getEnderecos());
		assertNull(clienteThree.getPf());
		assertEquals("imobile@gmail.com",clienteThree.getEmail());
		assertEquals(3,clienteThree.getId());
		assertEquals("Cristine Gomes",clienteThree.getNome());
		assertEquals("18-987654321",clienteThree.getTelefone());
		assertEquals("12.345.678/0001-90",clienteThree.getPj().getCnpj());
		assertEquals("123.456.789.123",clienteThree.getPj().getInscricaoEstadual());
		
		Cliente clienteSix = clientes.get(6);
		
		assertNotNull(clienteSix);
		assertNotNull(clienteSix.getId());
		assertNotNull(clienteSix.getProjeto());
		assertNull(clienteSix.getEnderecos());
		assertNull(clienteSix.getPf());
		assertEquals("imobile@gmail.com",clienteSix.getEmail());
		assertEquals(6,clienteSix.getId());
		assertEquals("Cristine Gomes",clienteSix.getNome());
		assertEquals("18-987654321",clienteSix.getTelefone());
		assertEquals("12.345.678/0001-90",clienteSix.getPj().getCnpj());
		assertEquals("123.456.789.123",clienteSix.getPj().getInscricaoEstadual());
	}
	
	

}
