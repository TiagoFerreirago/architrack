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
import com.architrack.architrack.entities.Pagamentos;
import com.architrack.architrack.entities.v1.vo.PagamentosVo;
import com.architrack.architrack.mocks.MockPagamento;


@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestConverterMapperPagamento {
	
	private MockPagamento input;

	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockPagamento();
		MockitoAnnotations.openMocks(this);
	}

	// validando a conversão entra entidadades através do Dozer
	@Test
	void testConverterPagamentosInVo() throws Throwable{
		PagamentosVo pagamentosVo = DozerMapper.parseObjectForEntity(input.mockPagamentos(1),PagamentosVo.class );
		
		assertNotNull(pagamentosVo);
		assertNotNull(pagamentosVo.getKey());
		assertNotNull(pagamentosVo.getProjeto());
		assertEquals("Fri Nov 08 00:00:00 BRT 2024",pagamentosVo.getDataPagamento().toString());
		assertEquals(1,pagamentosVo.getKey());
		assertEquals("Concluido",pagamentosVo.getStatus());
		assertEquals(54000.00,pagamentosVo.getValor());	
		
		
	}
	
	@Test
	void testConverterVoInPagamentos() throws Throwable{
		Pagamentos pagamentos = DozerMapper.parseObjectForEntity(input.mockPagamentosVo(1),Pagamentos.class);
		

		assertNotNull(pagamentos);
		assertNotNull(pagamentos.getId());
		assertNotNull(pagamentos.getProjeto());
		assertEquals("Fri Oct 18 00:00:00 BRT 2024",pagamentos.getDataPagamento().toString());
		assertEquals(1,pagamentos.getId());
		assertEquals("Aguardando",pagamentos.getStatus());
		assertEquals(78000.00,pagamentos.getValor());	
	}
	
	@Test
	void testConverterListPagamentosInVo() throws Throwable{
		List<PagamentosVo> pagamentosVo = DozerMapper.parseListObjectForEntity(input.mockListPagamentos(),PagamentosVo.class);
		
		PagamentosVo voTwo = pagamentosVo.get(2);
		
		assertNotNull(voTwo);
		assertNotNull(voTwo.getKey());
		assertNotNull(voTwo.getProjeto());
		assertEquals("Fri Nov 08 00:00:00 BRT 2024",voTwo.getDataPagamento().toString());
		assertEquals(2,voTwo.getKey());
		assertEquals("Concluido",voTwo.getStatus());
		assertEquals(54000.00,voTwo.getValor());	
		
		PagamentosVo voFive = pagamentosVo.get(5);
		
		assertNotNull(voFive);
		assertNotNull(voFive.getKey());
		assertNotNull(voFive.getProjeto());
		assertEquals("Fri Nov 08 00:00:00 BRT 2024",voFive.getDataPagamento().toString());
		assertEquals(5,voFive.getKey());
		assertEquals("Concluido",voFive.getStatus());
		assertEquals(54000.00,voFive.getValor());	
		
		PagamentosVo voEight = pagamentosVo.get(8);
		
		assertNotNull(voEight);
		assertNotNull(voEight.getKey());
		assertNotNull(voEight.getProjeto());
		assertEquals("Fri Nov 08 00:00:00 BRT 2024",voFive.getDataPagamento().toString());
		assertEquals(8,voEight.getKey());
		assertEquals("Concluido",voEight.getStatus());
		assertEquals(54000.00,voEight.getValor());	
	}
	@Test
	void testConverterListVoInPagamentos() throws Throwable{
		List<Pagamentos> pagamentos = DozerMapper.parseListObjectForEntity(input.mockListPagamentosVo(), Pagamentos.class);
		
		Pagamentos pagamento = pagamentos.get(1);
		
		assertNotNull(pagamento);
		assertNotNull(pagamento.getId());
		assertNotNull(pagamento.getProjeto());
		assertEquals("Fri Oct 18 00:00:00 BRT 2024",pagamento.getDataPagamento().toString());
		assertEquals(1,pagamento.getId());
		assertEquals("Aguardando",pagamento.getStatus());
		assertEquals(78000.00,pagamento.getValor());
		
		Pagamentos pagamentoThree = pagamentos.get(3);
		
		assertNotNull(pagamentoThree);
		assertNotNull(pagamentoThree.getId());
		assertNotNull(pagamentoThree.getProjeto());
		assertEquals("Fri Oct 18 00:00:00 BRT 2024",pagamentoThree.getDataPagamento().toString());
		assertEquals(3,pagamentoThree.getId());
		assertEquals("Aguardando",pagamentoThree.getStatus());
		assertEquals(78000.00,pagamentoThree.getValor());
		
		Pagamentos pagamentoSix = pagamentos.get(6);
		
		assertNotNull(pagamentoSix);
		assertNotNull(pagamentoSix.getId());
		assertNotNull(pagamentoSix.getProjeto());
		assertEquals("Fri Oct 18 00:00:00 BRT 2024",pagamentoSix.getDataPagamento().toString());
		assertEquals(6,pagamentoSix.getId());
		assertEquals("Aguardando",pagamentoSix.getStatus());
		assertEquals(78000.00,pagamentoSix.getValor());
	}
	
	

}
