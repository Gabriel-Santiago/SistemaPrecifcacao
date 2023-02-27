package br.com.SistemaPrecificacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SistemaPrecificacao.model.Item;
import br.com.SistemaPrecificacao.model.Produto;
import br.com.SistemaPrecificacao.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public void save(int id, Produto entity) {
		if(id != 0) {
			entity.setId(id);
		}
		produtoRepository.save(entity);
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
	
	public Produto findByItem(Item item) {
		return produtoRepository.findByItem(item);
	}
	
	public Produto findByNome(String str) {
		return produtoRepository.findByNome(str);
	}
}
