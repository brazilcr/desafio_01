package com.desafios.desafio_01.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import com.desafios.desafio_01.entities.Regiao;

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "resumao", 
			query = "SELECT * FROM Regiao",
			resultClass=Regiao.class
	)
})
@Entity
@Table(name = "tb_regiao")
public class Regiao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String codigo;
	private String data;
	private String sigla;
	private Double geracao;
	@Column(name = "preco_compra")
	private Double compra;
	@Column(name = "preco_medio")
	private Double precoMedio;

	public Regiao() {
	}

	public Regiao(Long id, String codigo, String localDateTime, String sigla, Double geracao, Double compra,
			Double precoMedio) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.data = localDateTime;
		this.sigla = sigla;
		this.geracao = geracao;
		this.compra = compra;
		this.precoMedio = precoMedio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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

	public Double getPrecoMedio() {
		return precoMedio;
	}

	public void setPrecoMedio(Double precoMedio) {
		this.precoMedio = precoMedio;
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
