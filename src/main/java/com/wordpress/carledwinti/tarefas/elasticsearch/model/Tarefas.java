package com.wordpress.carledwinti.tarefas.elasticsearch.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "tarefas", type = "tarefas", shards = 1)
public class Tarefas {

    private String descricao;
    private String status;
    private Long id;
    private Long duracao;
    private String observacao;
    private String responsavel;

    public Tarefas() { }

    public Tarefas(String descricao, String status, Long id, Long duracao, String observacao, String responsavel) {
        this.descricao = descricao;
        this.status = status;
        this.id = id;
        this.duracao = duracao;
        this.observacao = observacao;
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Tarefas{" +
                "descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", id=" + id +
                ", duracao=" + duracao +
                ", observacao=" + observacao +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}
