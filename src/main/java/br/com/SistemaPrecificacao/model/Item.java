package br.com.SistemaPrecificacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="itens")
public class Item {

	@Id
	@GeneratedValue(generator="sequence",strategy=GenerationType.SEQUENCE) 
	private int id;
	
	private String nome;
	private double preco;
	
	@ManyToOne
	@JoinColumn(name="itemProduto")
	@JsonIgnore
	private Produto produto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + ", preco=" + preco + ", produto=" + produto + "]";
	}

	public Item(int id, String nome, double preco, Produto produto) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.produto = produto;
	}

	public Item() {
		super();
	}	
}
