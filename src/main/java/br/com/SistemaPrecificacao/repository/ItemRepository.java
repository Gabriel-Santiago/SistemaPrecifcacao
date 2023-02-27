package br.com.SistemaPrecificacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SistemaPrecificacao.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	Item findByNome(String nome);
	
}
