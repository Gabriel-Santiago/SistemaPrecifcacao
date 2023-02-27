package br.com.SistemaPrecificacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.SistemaPrecificacao.model.Produto;
import br.com.SistemaPrecificacao.model.Usuario;
import br.com.SistemaPrecificacao.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public void save(int id, Usuario entity) {
		if(id != 0) {
			entity.setId(id);
		}
		entity.setSenha(new BCryptPasswordEncoder().encode(entity.getSenha()));
		usuarioRepository.save(entity);
	}
	
	public Usuario find(int id) {
		if (id < 1) {
			return null;
		}
		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public void delete(int id) {
		Usuario usuario = find(id);
		usuarioRepository.delete(usuario);
	}
	
	public void update(int id, Usuario entity) {	
		entity.setId(id);
		usuarioRepository.save(entity);				
	}
	
	public Usuario findByProduto(Produto produto) {
		return usuarioRepository.findByProduto(produto);
	}
}
