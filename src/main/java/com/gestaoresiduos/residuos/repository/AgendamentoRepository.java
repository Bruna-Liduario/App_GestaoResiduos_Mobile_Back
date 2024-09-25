package com.gestaoresiduos.residuos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestaoresiduos.residuos.entity.Agendamentos;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamentos, Long> {

}
