package com.wordpress.carledwinti.tarefas.elasticsearch.load;

import com.wordpress.carledwinti.tarefas.elasticsearch.model.Tarefas;
import com.wordpress.carledwinti.tarefas.elasticsearch.repository.TarefasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

    Logger logger = LoggerFactory.getLogger(Loaders.class);

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private TarefasRepository tarefasRepository;

    @PostConstruct
    @Transactional
    public  void loadAll(){

        logger.info("Carregando os dados ...");

        elasticsearchOperations.putMapping(Tarefas.class);

        tarefasRepository.save(getData());
        logger.info("Dados carregados com sucesso!");
    }

    private List<Tarefas> getData() {

        List<Tarefas> tarefas = new ArrayList<>();

        tarefas.add(new Tarefas("Ligar para o eletricista", "P", 231L, 20L, "-", "Alameno Lacale"));
        tarefas.add(new Tarefas("Abastecer o carro", "P", 257L, 50L, "Depende da agenda", "Teleco Maneco"));
        tarefas.add(new Tarefas("Ligar para a loja", "P", 234L, 20L, "Depende da agenda","Bambabe Cameli"));
        tarefas.add(new Tarefas("Enviar email para Zamcana", "F", 273L, 10L, "Urgente", "Pape Tareco"));
        tarefas.add(new Tarefas("Fazer revisão para viagem", "P", 287L, 70L, "-", "Alameno Lacale"));

        return tarefas;
    }
}
