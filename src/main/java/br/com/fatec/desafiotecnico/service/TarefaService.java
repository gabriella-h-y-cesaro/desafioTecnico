package br.com.fatec.desafiotecnico.service;
import br.com.fatec.desafiotecnico.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    private final ArrayList<Tarefa> listaTarefas = new ArrayList<>();
    // listar todos
    public List<Tarefa> listar() {
        return listaTarefas;
    }
    // buscar por índice
    public Tarefa buscarPorIndice(int indice) {
        if (indice < 0 || indice >= listaTarefas.size()) {
            return null;
        }
        return listaTarefas.get(indice);
    }
    // adicionar
    public Tarefa adicionar(Tarefa tarefa) {
        listaTarefas.add(tarefa);
        return tarefa;
    }
    // atualizar
    public Tarefa atualizar(int indice, Tarefa tarefa) {
        if (indice < 0 || indice >= listaTarefas.size()) {
            return null;
        }
        listaTarefas.set(indice, tarefa);
        return tarefa;
    }
    // deletar
    public boolean deletar(int indice) {
        if (indice < 0 || indice >= listaTarefas.size()) {
            return false;
        }
        listaTarefas.remove(indice);
        return true;
    }

}
