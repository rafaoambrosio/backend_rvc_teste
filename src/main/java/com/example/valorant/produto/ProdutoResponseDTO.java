package com.example.valorant.produto;

import java.util.Date;
import java.util.List;

public record ProdutoResponseDTO(
        Long id,
        String titulo,
        String descricao,
        String localizacao,
        String resumo,
        List<String> itensInclusos,
        List<String> dicas,
        List<String> observacoes,
        List<ProdutoFaixaPreco> faixaPreco,
        String urlVideo,
        int numeroDiarias,
        Boolean hospedagemInclusa,
        String roteiro,
        List<Date> dataDisponiveis,
        int limiteVagas
) {
    public ProdutoResponseDTO(Produto produto) {
        this(
                produto.getId(),
                produto.getTitulo(),
                produto.getDescricao(),
                produto.getLocalizacao(),
                produto.getResumo(),
                produto.getItensInclusos(),
                produto.getDicas(),
                produto.getObservacoes(),
                produto.getFaixaPreco(),
                produto.getUrlVideo(),
                produto.getNumeroDiarias(),
                produto.getHospedagemInclusa(),
                produto.getRoteiro(),
                produto.getDataDisponiveis(),
                produto.getLimiteVagas()
        );
    }
}

