package com.wordpress.carledwinti.tarefas.elasticsearch.resource;

import com.wordpress.carledwinti.tarefas.elasticsearch.builder.SearchQueryBuilder;
import com.wordpress.carledwinti.tarefas.elasticsearch.model.Tarefas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ManualSearchResource {

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    @GetMapping("/manual/search/{text}")
    public List<Tarefas> getAll(@PathVariable final String text) {

        return searchQueryBuilder.getAll(text);
    }
}
