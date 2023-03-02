package br.com.SistemaPrecificacao.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SistemaPrecificacao.model.Item;
import br.com.SistemaPrecificacao.model.Produto;
import br.com.SistemaPrecificacao.repository.ItemRepository;
import br.com.SistemaPrecificacao.repository.ProdutoRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public String save(int produto_id, Item entity) throws ParseException, IOException{
		Produto produto = produtoRepository.findById(produto_id).get();
		entity.setProduto(produto);
		
		entity = itemRepository.save(entity);
		itemRepository.flush();
		
		return Integer.toString(entity.getId());
	}
	
	public Item find(int id) {
		if (id < 1) {
			return null;
		}
		Optional<Item> item = itemRepository.findById(id);

		if (item.isPresent()) {
			return item.get();
		}
		return null;
	}

	public List<Item> findAll() {
		return itemRepository.findAll();
	}
	
	public void delete(int id) {
		Item item = find(id);
		itemRepository.delete(item);
	}
	
	public void update(int id, Item entity) {	
		entity.setId(id);
		itemRepository.save(entity);				
	}
	
	public Item findByNome(String str) {
		return itemRepository.findByNome(str);
	}
}
