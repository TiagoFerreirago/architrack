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
import com.architrack.architrack.entities.Documento;
import com.architrack.architrack.entities.v1.vo.DocumentoVo;
import com.architrack.architrack.mocks.MockDocumento;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TestConverterMapperDocumento {
	
	private MockDocumento input;

	
	@BeforeEach
	void setUp() throws Exception {
		input = new MockDocumento();
		MockitoAnnotations.openMocks(this);
	}

	// validando a conversão entra entidadades através do Dozer
	@Test
	void testConverterDocumentoInVo() throws ParseException{
		DocumentoVo documentoVo = DozerMapper.parseObjectForEntity(input.mockDocumento(1),DocumentoVo.class );
		
		assertNotNull(documentoVo);
		assertNotNull(documentoVo.getKey());
		assertNotNull(documentoVo.getProjeto());
		assertNotNull(documentoVo.getCliente());
		assertEquals("Wed Dec 25 00:00:00 BRT 2024",documentoVo.getDataEnvio().toString());
		assertEquals(1,documentoVo.getKey());
		assertEquals("Projeto Estrutural",documentoVo.getNomeDocumento());
		assertEquals("Técnico",documentoVo.getTipoDocumento());	
		
	}
	
	@Test
	void testConverterVoInDocumento() throws Throwable{
		Documento documento = DozerMapper.parseObjectForEntity(input.mockDocumentoVo(1),Documento.class);
		
		assertNotNull(documento);
		assertNotNull(documento.getId());
		assertNotNull(documento.getProjeto());
		assertNotNull(documento.getCliente());
		assertEquals("Wed Dec 11 00:00:00 BRT 2024",documento.getDataEnvio().toString());
		assertEquals(1,documento.getId());
		assertEquals("Licença Para Construção",documento.getNomeDocumento());
		assertEquals("Licenças",documento.getTipoDocumento());	
	}
	
	@Test
	void testConverterListDocumentoInVo() throws Throwable{
		List<DocumentoVo> documentosVo = DozerMapper.parseListObjectForEntity(input.mockListDocumento(),DocumentoVo.class);
		
		DocumentoVo voTwo = documentosVo.get(2);
		
		assertNotNull(voTwo);
		assertNotNull(voTwo.getKey());
		assertNotNull(voTwo.getProjeto());
		assertNotNull(voTwo.getCliente());
		assertEquals("Wed Dec 25 00:00:00 BRT 2024",voTwo.getDataEnvio().toString());
		assertEquals(2,voTwo.getKey());
		assertEquals("Projeto Estrutural",voTwo.getNomeDocumento());
		assertEquals("Técnico",voTwo.getTipoDocumento());	
		
		DocumentoVo voFive = documentosVo.get(5);
		
		assertNotNull(voFive);
		assertNotNull(voFive.getKey());
		assertNotNull(voFive.getProjeto());
		assertNotNull(voFive.getCliente());
		assertEquals("Wed Dec 25 00:00:00 BRT 2024",voFive.getDataEnvio().toString());
		assertEquals(5,voFive.getKey());
		assertEquals("Projeto Estrutural",voFive.getNomeDocumento());
		assertEquals("Técnico",voFive.getTipoDocumento());	
		
		DocumentoVo voEight = documentosVo.get(8);
		
		assertNotNull(voEight);
		assertNotNull(voEight.getKey());
		assertNotNull(voEight.getProjeto());
		assertNotNull(voEight.getCliente());
		assertEquals("Wed Dec 25 00:00:00 BRT 2024",voEight.getDataEnvio().toString());
		assertEquals(8,voEight.getKey());
		assertEquals("Projeto Estrutural",voEight.getNomeDocumento());
		assertEquals("Técnico",voEight.getTipoDocumento());	
	}
	@Test
	void testConverterListVoInDocumento() throws Throwable{
		List<Documento> documentos = DozerMapper.parseListObjectForEntity(input.mockListDocumentoVo(), Documento.class);
		
		Documento documento = documentos.get(1);
		
		assertNotNull(documento);
		assertNotNull(documento.getId());
		assertNotNull(documento.getProjeto());
		assertNotNull(documento.getCliente());
		assertEquals("Wed Dec 11 00:00:00 BRT 2024",documento.getDataEnvio().toString());
		assertEquals(1,documento.getId());
		assertEquals("Licença Para Construção",documento.getNomeDocumento());
		assertEquals("Licenças",documento.getTipoDocumento());	
		
		Documento documentoThree = documentos.get(3);
		
		assertNotNull(documentoThree);
		assertNotNull(documentoThree.getId());
		assertNotNull(documentoThree.getProjeto());
		assertNotNull(documentoThree.getCliente());
		assertEquals("Wed Dec 11 00:00:00 BRT 2024",documentoThree.getDataEnvio().toString());
		assertEquals(3,documentoThree.getId());
		assertEquals("Licença Para Construção",documentoThree.getNomeDocumento());
		assertEquals("Licenças",documentoThree.getTipoDocumento());	
		
		Documento documentoSix = documentos.get(6);
		
		assertNotNull(documentoSix);
		assertNotNull(documentoSix.getId());
		assertNotNull(documentoSix.getProjeto());
		assertNotNull(documentoSix.getCliente());
		assertEquals("Wed Dec 11 00:00:00 BRT 2024",documentoSix.getDataEnvio().toString());
		assertEquals(6,documentoSix.getId());
		assertEquals("Licença Para Construção",documentoSix.getNomeDocumento());
		assertEquals("Licenças",documentoSix.getTipoDocumento());	
	}
	
	

}
