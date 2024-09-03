package com.architrack.architrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architrack.architrack.dozermapper.config.DozerMapper;
import com.architrack.architrack.entities.Documento;
import com.architrack.architrack.entities.v1.vo.DocumentoVo;
import com.architrack.architrack.exception.ResponseNotFoundHandlerException;
import com.architrack.architrack.repository.DocumentoRepository;

@Service
public class DocumentoService {

	@Autowired
	private DocumentoRepository repository;
	
	private DozerMapper mapper;


	public DocumentoVo findById(Long id) {
		Documento documento = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		DocumentoVo vo = mapper.parseObjectForEntity(documento, DocumentoVo.class);
		return vo;
		
	}
	
	public List<DocumentoVo> findAll() {
		List<Documento>documento = repository.findAll();
		List<DocumentoVo>listVo = mapper.parseListObjectForEntity(documento, DocumentoVo.class);
		return listVo;
	}
	
	public DocumentoVo create(DocumentoVo documento) {
		Documento arq = mapper.parseObjectForEntity(documento, Documento.class);
		DocumentoVo vo = mapper.parseObjectForEntity(repository.save(arq), DocumentoVo.class);
		return vo;
	}
	
	public DocumentoVo update(DocumentoVo documento) {
		Documento doc = repository.findById(documento.getKey()).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		doc.setCliente(documento.getCliente());
		doc.setDataEnvio(documento.getDataEnvio());
		doc.setNomeDocumento(documento.getNomeDocumento());
		doc.setProjeto(documento.getProjeto());
		doc.setTipoDocumento(documento.getTipoDocumento());
		
		DocumentoVo vo = mapper.parseObjectForEntity(repository.save(doc), DocumentoVo.class);
		return vo;
	}
	
	public void delete(Long id) {
		Documento documento = repository.findById(id).orElseThrow(
				() -> new ResponseNotFoundHandlerException("Id not found"));
		repository.delete(documento);
	}
}
