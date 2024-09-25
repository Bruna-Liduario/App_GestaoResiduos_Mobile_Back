package com.gestaoresiduos.residuos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestaoresiduos.residuos.entity.Agendamentos;
import com.gestaoresiduos.residuos.repository.AgendamentoRepository;

@Service
@Transactional
public class AgendamentoService {
	
	    @Autowired
	    private AgendamentoRepository repository;
	    

	    public Agendamentos salvar(Agendamentos agendamento) {
			return repository.save(agendamento);
		}
		
		public List<Agendamentos> listarTodos() {
			return repository.findAll();
		}
		
		public Optional<Agendamentos> buscarPorId(Long id) {
			return repository.findById(id);
		}
		
		public void excluir(Long id) {
			repository.deleteById(id);
		}

}
