package br.com.SistemaPrecificacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SistemaPrecificacao.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{	
	
	Usuario findByEmail(String email);
	
}
