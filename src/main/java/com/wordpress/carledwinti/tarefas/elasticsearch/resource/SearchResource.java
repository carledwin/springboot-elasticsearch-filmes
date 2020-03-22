package com.wordpress.carledwinti.tarefas.elasticsearch.resource;

import com.wordpress.carledwinti.tarefas.elasticsearch.model.Tarefas;
import com.wordpress.carledwinti.tarefas.elasticsearch.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class SearchResource {

    @Autowired
    TarefasRepository tarefasRepository;

    @GetMapping("/search/descricao/{text}")
    public List<Tarefas> searchDescricao(@PathVariable final String text) {
        return tarefasRepository.findByDescricao(text);
    }

    @GetMapping("/search/status/{text}")
    public List<Tarefas> searchStatus(@PathVariable final String text) {
        return tarefasRepository.findByStatus(text);
    }

    @GetMapping("/doc/{id}")
    public List<Tarefas> findById(@PathVariable final Long id) {
        return tarefasRepository.findById(id);
    }

    @GetMapping("/search/all")
    public List<Tarefas> searchAll() {

        List<Tarefas> tarefas = new ArrayList<>();

        Iterable<Tarefas> tarefasI = tarefasRepository.findAll();
        tarefasI.forEach(tarefas::add);

        return tarefas;
    }
}
