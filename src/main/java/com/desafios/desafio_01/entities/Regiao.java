package com.desafios.desafio_01.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.desafios.desafio_01.entities.Agente;

@Entity
@Table(name = "tb_regiao")
public class Regiao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome_regiao")
	private Double geracao;
	@Column(name = "preco_compra")
	private Double compra;
	@Column(name = "preco_medio")
	private Double pMedio;
	
	public Regiao() {
	}

	public Regiao(Long id, Double geracao, Double compra, Double pMedio) {
		super();
		this.id = id;
		this.geracao = geracao;
		this.compra = compra;
		this.pMedio = pMedio;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getGeracao() {
		return geracao;
	}

	public void setGeracao(Double geracao) {
		this.geracao = geracao;
	}

	public Double getCompra() {
		return compra;
	}

	public void setCompra(Double compra) {
		this.compra = compra;
	}

	public Double getpMedio() {
		return pMedio;
	}

	public void setpMedio(Double pMedio) {
		this.pMedio = pMedio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agente other = (Agente) obj;
		return Objects.equals(id, other.getId());
	}
}
