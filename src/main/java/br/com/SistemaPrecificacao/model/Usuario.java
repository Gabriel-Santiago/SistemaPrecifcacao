package br.com.SistemaPrecificacao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario{
	
	@Id
	@GeneratedValue(generator="sequence",strategy=GenerationType.SEQUENCE) 
	private int id;

	@Column(nullable =false, unique =true)
	private String email;
	@Column(nullable =false)
	private String senha;
	
	private String cnpj;
	
	private String nome;
	private String telefone;
	private String cep;
	private String bairro;
	private String municipio;
	private String uf;
	private String numero;
	
	private List<Atividade> atividade_principal = new ArrayList<Atividade>();

	@OneToMany(mappedBy = "usuarios")
	private Produto produto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Atividade> getAtividade_principal() {
		return atividade_principal;
	}

	public void setAtividade_principal(List<Atividade> atividade_principal) {
		this.atividade_principal = atividade_principal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + ", cnpj=" + cnpj + ", nome=" + nome
				+ ", telefone=" + telefone + ", cep=" + cep + ", bairro=" + bairro + ", municipio=" + municipio
				+ ", uf=" + uf + ", numero=" + numero + ", atividade_principal=" + atividade_principal + ", produto="
				+ produto + "]";
	}

	public Usuario(int id, String email, String senha, String cnpj, String nome, String telefone, String cep,
			String bairro, String municipio, String uf, String numero, List<Atividade> atividade_principal,
			Produto produto) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.cep = cep;
		this.bairro = bairro;
		this.municipio = municipio;
		this.uf = uf;
		this.numero = numero;
		this.atividade_principal = atividade_principal;
		this.produto = produto;
	}

	public Usuario() {
		super();
	}
}
