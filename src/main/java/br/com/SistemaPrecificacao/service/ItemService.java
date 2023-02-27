package br.com.SistemaPrecificacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SistemaPrecificacao.model.Item;
import br.com.SistemaPrecificacao.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public void save(int id, Item entity) {
		if(id != 0) {
			entity.setId(id);
		}
		itemRepository.save(entity);
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
