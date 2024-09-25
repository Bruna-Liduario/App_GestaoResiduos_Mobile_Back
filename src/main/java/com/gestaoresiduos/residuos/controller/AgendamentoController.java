package com.gestaoresiduos.residuos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoresiduos.residuos.entity.Agendamentos;
import com.gestaoresiduos.residuos.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService service;
	

	@PostMapping("/salvar")
	public ResponseEntity<Agendamentos> salvar(@RequestBody Agendamentos agendamento) {
		Agendamentos savedAgendamento = service.salvar(agendamento);
		if (savedAgendamento != null) {
			return ResponseEntity.ok(savedAgendamento);
		}
		return ResponseEntity.badRequest().build(); // Se erro ao salvar
	}
	
	@GetMapping("/listar")
	public List<Agendamentos> listarTodos() {
		return service.listarTodos();
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Agendamentos> buscarPorId(@PathVariable(name = "id") Long id) {
		Optional<Agendamentos> agendamento = service.buscarPorId(id);
		if (agendamento.isPresent()) {
			return ResponseEntity.ok(agendamento.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> excluir(@PathVariable(name = "id") Long id) {
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
