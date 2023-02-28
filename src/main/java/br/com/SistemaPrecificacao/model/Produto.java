package br.com.SistemaPrecificacao.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="produtos")
public class Produto {

	@Id
	@GeneratedValue(generator="sequence",strategy=GenerationType.SEQUENCE) 
	private int id;
	
	private String nome;
	private double preco;
	
	private Double imposto;
	private Double taxaCartao;
	private Double lucro;
	
	@ManyToOne
	@JoinColumn(name="produtoUsuario")
	@JsonIgnore
	private Usuario usuario;
	
	@OneToMany(mappedBy = "produtos")
	private List<Item> item;

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

	public Double getLucro() {
		return lucro;
	}

	public void setLucro(Double lucro) {
		this.lucro = lucro;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}

	public Double getTaxaCartao() {
		return taxaCartao;
	}

	public void setTaxaCartao(Double taxaCartao) {
		this.taxaCartao = taxaCartao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", imposto=" + imposto + ", taxaCartao="
				+ taxaCartao + ", lucro=" + lucro + ", usuario=" + usuario + ", item=" + item + "]";
	}

	public Produto(int id, String nome, double preco, Double imposto, Double taxaCartao,
			Double lucro, Usuario usuario, List<Item> item) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.imposto = imposto;
		this.taxaCartao = taxaCartao;
		this.lucro = lucro;
		this.usuario = usuario;
		this.item = item;
	}
	
	public double getUsaCartao() {
		
		double soma = item.stream()
				.mapToDouble(x -> x.getValorItem())
				.sum();

		double preco = soma * ((lucro / 100) + 1) + imposto;
		double novoPreco = preco * ((taxaCartao / 100) + 1);
		
		return novoPreco;
	}
	
	public double getSemCartao() {
		
		double soma = item.stream()
				.mapToDouble(x -> x.getValorItem())
				.sum();

		double preco = soma * ((lucro / 100) + 1) + imposto;
		
		return preco;
	}

	public Produto() {
		super();
	}	
}
