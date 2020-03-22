package com.wordpress.carledwinti.tarefas.elasticsearch.config;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.File;
import java.io.IOException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.wordpress.carledwinti.tarefas.elasticsearch.repository")
public class ElasticsearchConfiguration {

    Logger logger = LoggerFactory.getLogger(ElasticsearchConfiguration.class);

    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {

        File tempDir = null;

        try {
            tempDir = File.createTempFile("elastc", Long.toString(System.nanoTime()));

            logger.info("Echo path dir: " + tempDir.getAbsolutePath());

            Settings.Builder builder = Settings.settingsBuilder()
                    .put("http.enabled", "true") //1
                    .put("index.number_of_shards", "1")
                    .put("path.data", new File(tempDir, "data").getAbsoluteFile()) //2
                    .put("path.logs", new File(tempDir, "logs").getAbsoluteFile()) //2
                    .put("path.work", new File(tempDir, "work").getAbsoluteFile()) //2
                    .put("path.home", tempDir); //3

            return new ElasticsearchTemplate(nodeBuilder()
                    .local(true)
                    .settings(builder)
                    .node()
                    .client());
        } catch (Exception e) {
            logger.error("Falha ao tentar criar o arquivo temp-elastic: " + e.getMessage());
            return null;
        }
    }

}
