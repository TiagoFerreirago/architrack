package com.architrack.architrack.test.entities.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.architrack.architrack.entities.Projeto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id","valor","dataPagamento","status","projeto"})
public class PagamentosVo extends RepresentationModel<PagamentosVo> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonPropertyOrder("id")
	@Mapping("id")
	private Long key;
	private Double valor;
	private Date dataPagamento;
	private String status;
	private Projeto projeto;
	
	public PagamentosVo() {
		
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataPagamento, key, projeto, status, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagamentosVo other = (PagamentosVo) obj;
		return Objects.equals(dataPagamento, other.dataPagamento) && Objects.equals(key, other.key)
				&& Objects.equals(projeto, other.projeto) && Objects.equals(status, other.status)
				&& Objects.equals(valor, other.valor);
	}
	
	
}
