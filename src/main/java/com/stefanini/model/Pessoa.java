package com.stefanini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_PESSOA")
public class Pessoa {
	private String nome;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String cpf;
	private Integer idade;
	
	public Pessoa(Integer id, String nome, String cpf, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	public Pessoa() {}

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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", id=" + id + ", cpf=" + cpf + ", idade=" + idade + "]";
	}
	
}
