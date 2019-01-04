package com.stefanini.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_CANDIDATO")
public class Candidato {
	private String nome;
	
	@Id
	private Integer numero;
	
	private Integer quantidadeVotos;
	
	private String cpf;
	
	public Candidato(String nome, String cpf, Integer numero, Integer quantidadeVotos) {
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;
		this.quantidadeVotos = quantidadeVotos;
	}
	public Candidato() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getQuantidadeVotos() {
		return quantidadeVotos;
	}
	public void setQuantidadeVotos(Integer quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	@Override
	public String toString() {
		return "Candidato [nome=" + nome + ", cpf=" + cpf + ", numero=" + numero + "]";
	}
	
}
