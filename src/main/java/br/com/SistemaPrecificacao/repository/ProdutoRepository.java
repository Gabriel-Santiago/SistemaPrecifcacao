package br.com.SistemaPrecificacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SistemaPrecificacao.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	Produto findByItem(Produto item);
	
	Produto findByNome(String nome);
	
}
