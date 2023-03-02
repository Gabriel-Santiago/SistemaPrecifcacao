package br.com.SistemaPrecificacao.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.SistemaPrecificacao.model.Usuario;
import br.com.SistemaPrecificacao.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> findall() {
		return new ResponseEntity<List<Usuario>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Usuario> find(@PathVariable("id") int id) {
		Usuario usuario = service.find(id);

		if (usuario != null) {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/search")
	public ResponseEntity<Usuario> findByName(@RequestParam("nome") String email) {
		Usuario usuario = service.findByEmail(email);

		if (usuario != null) {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping()
	public void save(@RequestBody Usuario usuario) throws Exception {
		
		// API RECEITA FEDERAL
		URL url = new URL("https://receitaws.com.br/v1\r\n"
				+ "/cnpj/" + usuario.getCnpj());
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		
		String cnpj = "";
		StringBuilder jsonCnpj = new StringBuilder();
		
		while((cnpj = br.readLine()) != null) {
			jsonCnpj.append(cnpj);
		}
		
		Usuario userAux = new Gson().fromJson(jsonCnpj.toString(), Usuario.class);
		
		usuario.setCnpj(userAux.getCnpj());
		usuario.setNome(userAux.getNome());
		usuario.setTelefone(userAux.getTelefone());
		usuario.setCep(userAux.getCep());
		usuario.setBairro(userAux.getBairro());
		usuario.setMunicipio(userAux.getMunicipio());
		usuario.setUf(userAux.getUf());
		usuario.setNumero(userAux.getNumero());
		
		//
		
		service.save(0, usuario);
	}

	@PutMapping(path = "/{id}")
	public void update(@PathVariable("id") int id, @RequestBody Usuario usuario) {
		service.save(id, usuario);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}

}
