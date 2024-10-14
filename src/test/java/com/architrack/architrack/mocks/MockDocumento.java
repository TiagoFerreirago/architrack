package com.architrack.architrack.mocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.architrack.architrack.entities.Cliente;
import com.architrack.architrack.entities.Documento;
import com.architrack.architrack.entities.Projeto;
import com.architrack.architrack.entities.v1.vo.DocumentoVo;

public class MockDocumento {

	public Documento mockDocumento(int number) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Documento documento = new Documento();
		documento.setCliente(new Cliente());
		documento.setDataEnvio(format.parse("25/12/2024"));
		documento.setId((long)number);
		documento.setNomeDocumento("Projeto Estrutural");
		documento.setProjeto(new Projeto());
		documento.setTipoDocumento("Técnico");
		return documento;
	}
	
		
		public DocumentoVo mockDocumentoVo(int number) throws ParseException {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			DocumentoVo vo = new DocumentoVo();
			vo.setCliente(new Cliente());
			vo.setDataEnvio(format.parse("11/12/2024"));
			vo.setKey((long)number);
			vo.setNomeDocumento("Licença Para Construção");
			vo.setProjeto(new Projeto());
			vo.setTipoDocumento("Licenças");
			return vo;
		}
		
		public Documento mockDocumento() throws ParseException {
			return mockDocumento(1);
			
		}
		
		public DocumentoVo mockDocumentoVo() throws ParseException {
			return mockDocumentoVo(1);
			
		}
		
		public List<Documento>mockListDocumento() throws ParseException{
			List<Documento> list = new ArrayList<>();
			for(int i = 0; i < 10; i++) {
				list.add(mockDocumento(i));
			}
			return list;
		}
		
		public List<DocumentoVo>mockListDocumentoVo() throws ParseException{
			List<DocumentoVo> vo = new ArrayList<>();
			for(int i = 0; i < 10; i++) {
				vo.add(mockDocumentoVo(i));
			}
			return vo;
		}
}
