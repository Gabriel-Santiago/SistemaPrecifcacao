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
	
	private NomePreco nomePreco;
	
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

	public NomePreco getNomePreco() {
		return nomePreco;
	}

	public void setNomePreco(NomePreco nomePreco) {
		this.nomePreco = nomePreco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", nomePreco=" + nomePreco + ", produto=" + produto + "]";
	}

	public Item(int id, NomePreco nomePreco, Produto produto) {
		this.id = id;
		this.nomePreco = nomePreco;
		this.produto = produto;
	}

	public Item() {
		super();
	}	
}
