package com.example.valorant.produto;

import jakarta.persistence.*;

@Entity
@Table(name = "produto_faixas_preco")
public class ProdutoFaixaPreco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String faixa;
    private String preco;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Long getProduto() {
        return produto.getId();
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
