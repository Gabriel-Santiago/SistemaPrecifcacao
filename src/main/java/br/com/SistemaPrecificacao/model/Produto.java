package br.com.SistemaPrecificacao.model;

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
	
	private NomePreco nomePreco;
	private Double lucro;
	
	@ManyToOne
	@JoinColumn(name="produtoUsuario")
	@JsonIgnore
	private Usuario usuario;
	
	@OneToMany(mappedBy = "produtos")
	private Item item;

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

	public Double getLucro() {
		return lucro;
	}

	public void setLucro(Double lucro) {
		this.lucro = lucro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nomePreco=" + nomePreco + ", lucro=" + lucro + ", usuario=" + usuario
				+ ", item=" + item + "]";
	}

	public Produto(int id, NomePreco nomePreco, Double lucro, Usuario usuario, Item item) {
		this.id = id;
		this.nomePreco = nomePreco;
		this.lucro = lucro;
		this.usuario = usuario;
		this.item = item;
	}

	public Produto() {
		super();
	}
	
	
//	public double valor() {
//		
//	}	
}
