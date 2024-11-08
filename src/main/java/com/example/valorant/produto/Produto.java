package com.example.valorant.produto;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Entity(name = "produtos")
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String localizacao;
    private String resumo;

    @Column(name = "itens_inclusos", columnDefinition = "TEXT[]")
    private List<String> itensInclusos;

    @Column(name = "dicas", columnDefinition = "TEXT[]")
    private List<String> dicas;

    @Column(name = "observacoes", columnDefinition = "TEXT[]")
    private List<String> observacoes;
    
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoFaixaPreco> faixaPreco = new ArrayList<>();

    private String urlVideo;
    private int numeroDiarias;
    private Boolean hospedagemInclusa;

    private String roteiro;

    @Column(name = "data_disponiveis", columnDefinition = "DATE[]")
    private List<Date> dataDisponiveis;

    private int limiteVagas;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<String> getItensInclusos() {
        return itensInclusos;
    }

    public void setItensInclusos(List<String> itensInclusos) {
        this.itensInclusos = itensInclusos;
    }

    public List<String> getDicas() {
        return dicas;
    }

    public void setDicas(List<String> dicas) {
        this.dicas = dicas;
    }

    public List<String> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<String> observacoes) {
        this.observacoes = observacoes;
    }

    public List<ProdutoFaixaPreco> getFaixaPreco() {
        return faixaPreco;
    }

    public void setFaixaPreco(List<ProdutoFaixaPreco> faixaPreco) {
        this.faixaPreco = faixaPreco;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public int getNumeroDiarias() {
        return numeroDiarias;
    }

    public void setNumeroDiarias(int numeroDiarias) {
        this.numeroDiarias = numeroDiarias;
    }

    public Boolean getHospedagemInclusa() {
        return hospedagemInclusa;
    }

    public void setHospedagemInclusa(Boolean hospedagemInclusa) {
        this.hospedagemInclusa = hospedagemInclusa;
    }

    public String getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(String roteiro) {
        this.roteiro = roteiro;
    }

    public List<Date> getDataDisponiveis() {
        return dataDisponiveis;
    }

    public void setDataDisponiveis(List<Date> dataDisponiveis) {
        this.dataDisponiveis = dataDisponiveis;
    }

    public int getLimiteVagas() {
        return limiteVagas;
    }

    public void setLimiteVagas(int limiteVagas) {
        this.limiteVagas = limiteVagas;
    }
}