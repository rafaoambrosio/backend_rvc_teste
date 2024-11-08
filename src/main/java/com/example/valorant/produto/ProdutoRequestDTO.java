package com.example.valorant.produto;

import java.util.Date;
import java.util.List;

public record ProdutoRequestDTO(
        String titulo,
        String descricao,
        String localizacao,
        String resumo,
        List<String> itensInclusos,
        List<String> dicas,
        List<String> observacoes,
        List<List<String>> faixaPreco,
        String urlVideo,
        int numeroDiarias,
        Boolean hospedagemInclusa,
        String roteiro,
        List<Date> dataDisponiveis,
        int limiteVagas
) { }
