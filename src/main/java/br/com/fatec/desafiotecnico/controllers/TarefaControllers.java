package br.com.fatec.desafiotecnico.controllers;
import br.com.fatec.desafiotecnico.model.Tarefa;
import br.com.fatec.desafiotecnico.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaControllers {

    private final TarefaService tarefaService;
    public TarefaControllers(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }
    // GET - listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        return ResponseEntity.ok(tarefaService.listar());
    }
    // GET - buscar usuário por índice
    @GetMapping("/{indice}")
    public ResponseEntity<Tarefa> buscarPorIndice(@PathVariable int indice) {
        Tarefa tarefa = tarefaService.buscarPorIndice(indice);
        if (tarefa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefa);
    }
    // POST - adicionar usuário
    @PostMapping("/adicionar")
    public ResponseEntity<Tarefa> adicionar(@RequestBody Tarefa tarefa) {
        Tarefa novoTarefa = tarefaService.adicionar(tarefa);
        return ResponseEntity.status(201).body(novoTarefa);
    }
    // PUT - atualizar usuário
    @PutMapping("/atualizar={indice}")
    public ResponseEntity<Tarefa> atualizar(
            @PathVariable int indice,
            @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizar(indice, tarefa);
        if (tarefaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefaAtualizada);
    }
    // DELETE - remover usuário
    @DeleteMapping("/remove={indice}")
    public ResponseEntity<Void> deletar(@PathVariable int indice) {
        boolean removido = tarefaService.deletar(indice);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
