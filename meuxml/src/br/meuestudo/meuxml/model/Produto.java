package br.meuestudo.meuxml.model;

import java.io.Serializable;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Double preco;

	public Produto() {
	}
	
	public Produto(String nome, Double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public Double getPreco() {
		return preco;
	}
	
	@Override
	public String toString() {
		return "Produto: " + this.getNome() + "Preco: R$ " + this.getPreco();
	}
	
}
