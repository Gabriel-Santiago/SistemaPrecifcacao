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

import br.com.SistemaPrecificacao.model.Item;
import br.com.SistemaPrecificacao.service.ItemService;

@RestController
@RequestMapping(path = "/itens")
public class ItemController {

	@Autowired
	ItemService service;

	@GetMapping()
	public ResponseEntity<List<Item>> findall() {
		return new ResponseEntity<List<Item>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Item> find(@PathVariable("id") int id) {
		Item item = service.find(id);

		if (item != null) {
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		} else {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/search")
	public ResponseEntity<Item> findByName(@RequestParam("nome") String nome) {
		Item item = service.findByNome(nome);

		if (item != null) {
			return new ResponseEntity<Item>(item, HttpStatus.OK);
		} else {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "/produtos/{id}/itens")
	public String save(@PathVariable("id") int produto_id, @RequestBody Item item)
			throws ParseException, IOException, InterruptedException {
		return service.save(produto_id, item);
	}

	@PutMapping(path = "/{id}")
	public void update(@PathVariable("id") int id, @RequestBody Item item) {
		service.update(id, item);
	}

	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") int id) {
		service.delete(id);
	}
}
