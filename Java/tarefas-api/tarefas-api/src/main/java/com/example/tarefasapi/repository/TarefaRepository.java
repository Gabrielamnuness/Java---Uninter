package com.example.tarefasapi.repository;

import com.example.tarefasapi.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}

