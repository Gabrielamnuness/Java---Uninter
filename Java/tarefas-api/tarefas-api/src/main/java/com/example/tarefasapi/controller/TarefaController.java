package com.example.tarefasapi.controller;

import com.example.tarefasapi.model.Tarefa;
import com.example.tarefasapi.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public List<Tarefa> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id) {
        return tarefaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarefa createTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaDetails) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setNome(tarefaDetails.getNome());
                    tarefa.setDataEntrega(tarefaDetails.getDataEntrega());
                    tarefa.setResponsavel(tarefaDetails.getResponsavel());
                    return ResponseEntity.ok(tarefaRepository.save(tarefa));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTarefa(@PathVariable Long id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefaRepository.delete(tarefa);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

