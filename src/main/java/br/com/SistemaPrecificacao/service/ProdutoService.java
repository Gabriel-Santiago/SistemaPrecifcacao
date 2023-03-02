package br.com.SistemaPrecificacao.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SistemaPrecificacao.model.Produto;
import br.com.SistemaPrecificacao.model.Usuario;
import br.com.SistemaPrecificacao.repository.ProdutoRepository;
import br.com.SistemaPrecificacao.repository.UsuarioRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public String save(int usuario_id, Produto entity) throws ParseException, IOException{
		Usuario usuario = usuarioRepository.findById(usuario_id).get();
		entity.setUsuario(usuario);
		
		entity = produtoRepository.save(entity);
		produtoRepository.flush();
		return Integer.toString(entity.getId());
	}
	
	public Produto find(int id) {
		if (id < 1) {
			return null;
		}
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			return produto.get();
		}
		return null;
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public void delete(int id) {
		Produto produto = find(id);
		produtoRepository.delete(produto);
	}
	
	public void update(int id, Produto entity) {	
		entity.setId(id);
		produtoRepository.save(entity);				
	}
	
	public Produto findByNome(String str) {
		return produtoRepository.findByNome(str);
	}
}
