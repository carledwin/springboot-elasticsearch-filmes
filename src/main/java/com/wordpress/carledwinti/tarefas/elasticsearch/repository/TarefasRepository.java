package com.wordpress.carledwinti.tarefas.elasticsearch.repository;

import com.wordpress.carledwinti.tarefas.elasticsearch.model.Tarefas;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TarefasRepository extends ElasticsearchRepository<Tarefas, Long> {

    List<Tarefas> findByDescricao(String text);
    List<Tarefas> findByStatus(String text);
    List<Tarefas> findById(Long id);
}
