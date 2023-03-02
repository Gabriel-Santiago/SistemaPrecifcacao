package br.com.SistemaPrecificacao.controller;

import java.io.IOException;
import java.text.ParseException;
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

import br.com.SistemaPrecificacao.model.Produto;
import br.com.SistemaPrecificacao.service.ProdutoService;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	@GetMapping()
	public ResponseEntity<List<Produto>> findall() {
		return new ResponseEntity<List<Produto>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Produto> find(@PathVariable("id") int id) {
		Produto produto = service.find(id);

		if (produto != null) {
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/search")
	public ResponseEntity<Produto> findByName(@RequestParam("nome") String nome) {
		Produto produto = service.findByNome(nome);

		if (produto != null) {
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "/usuarios/{id}/produtos")
	public String save(@PathVariable("id") int usuario_id, @RequestBody Produto produto)
			throws ParseException, IOException, InterruptedException {
		return service.save(usuario_id, produto);
	}
	
	@PutMapping(path = "/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Produto produto) {
        service.update(id, produto);
    }
	
	@DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

}
