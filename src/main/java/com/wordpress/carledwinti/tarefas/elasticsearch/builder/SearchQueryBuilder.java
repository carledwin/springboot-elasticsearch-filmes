package com.wordpress.carledwinti.tarefas.elasticsearch.builder;

import com.wordpress.carledwinti.tarefas.elasticsearch.model.Tarefas;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public List<Tarefas> getAll(String text) {

        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.queryStringQuery(text)
                        .lenient(true)
                        .field("descricaco")
                        .field("observacao"))
                .should(QueryBuilders.queryStringQuery("*" + text + "*")
                        .lenient(true)
                        .field("descricaco")
                        .field("observacao"))
                .should(QueryBuilders.queryStringQuery("*" + text)
                        .lenient(true)
                        .field("descricaco")
                        .field("observacao"))
                .should(QueryBuilders.queryStringQuery(text + "*")
                        .lenient(true)
                        .field("descricaco")
                        .field("observacao"));


        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();

        List<Tarefas> tarefas = elasticsearchTemplate.queryForList(nativeSearchQuery, Tarefas.class);

        return tarefas;
    }
}
