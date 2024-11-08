package com.example.valorant.controller;

import com.example.valorant.produto.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private ProdutoRepository repository;

    // Endpoint para buscar um produto específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoById(@PathVariable Long id) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO(optionalProduto.get());
            return ResponseEntity.ok(produtoResponseDTO);
        } else {
            throw new EntityNotFoundException("Produto não encontrado com id: " + id);
        }
    }

    // Endpoint para buscar todos os produtos
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProdutoResponseDTO> getAllProdutos() {
        return repository.findAll().stream().map(ProdutoResponseDTO::new).toList();
    }

@CrossOrigin(origins = "*", allowedHeaders = "*")
@PostMapping("/produtos")
@Transactional
public ResponseEntity<ProdutoResponseDTO> createProduto(@RequestBody ProdutoRequestDTO data) {
    Produto produto = new Produto();
    produto.setTitulo(data.titulo());
    produto.setDescricao(data.descricao());
    produto.setLocalizacao(data.localizacao());
    produto.setResumo(data.resumo());
    produto.setItensInclusos(data.itensInclusos());
    produto.setDicas(data.dicas());
    produto.setObservacoes(data.observacoes());
    List<ProdutoFaixaPreco> faixaPrecoList = data.faixaPreco().stream().map(item -> {
        ProdutoFaixaPreco faixaPreco = new ProdutoFaixaPreco();
        faixaPreco.setFaixa(item.get(0));
        faixaPreco.setPreco(item.get(1));
        faixaPreco.setProduto(produto); // Set the association
        return faixaPreco;
    }).collect(Collectors.toList());

    produto.setFaixaPreco(faixaPrecoList);
    produto.setUrlVideo(data.urlVideo());
    produto.setNumeroDiarias(data.numeroDiarias());
    produto.setHospedagemInclusa(data.hospedagemInclusa());
    produto.setRoteiro(data.roteiro());
    produto.setDataDisponiveis(data.dataDisponiveis());
    produto.setLimiteVagas(data.limiteVagas());
    repository.save(produto);
    return ResponseEntity.ok(new ProdutoResponseDTO(produto));
}

    // Endpoint para atualizar um produto existente
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoResponseDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO data) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setTitulo(data.titulo());
            produto.setDescricao(data.descricao());
            produto.setLocalizacao(data.localizacao());
            produto.setResumo(data.resumo());
            produto.setItensInclusos(data.itensInclusos());
            produto.setDicas(data.dicas());
            produto.setObservacoes(data.observacoes());
            
            // Clear the existing faixaPreco list to avoid orphan issues
            produto.getFaixaPreco().clear();

            // Add each new faixaPreco item, setting the association with produto
            data.faixaPreco().forEach(item -> {
                ProdutoFaixaPreco faixaPreco = new ProdutoFaixaPreco();
                faixaPreco.setFaixa(item.get(0));
                faixaPreco.setPreco(item.get(1));
                faixaPreco.setProduto(produto);
                produto.getFaixaPreco().add(faixaPreco);
            });

            produto.setUrlVideo(data.urlVideo());
            produto.setNumeroDiarias(data.numeroDiarias());
            produto.setHospedagemInclusa(data.hospedagemInclusa());
            produto.setRoteiro(data.roteiro());
            produto.setDataDisponiveis(data.dataDisponiveis());
            produto.setLimiteVagas(data.limiteVagas());
            repository.save(produto);
            return ResponseEntity.ok(new ProdutoResponseDTO(produto));
        } else {
            throw new EntityNotFoundException("Produto não encontrado com id: " + id);
        }
    }


    // Endpoint para deletar um produto
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            repository.delete(optionalProduto.get());
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException("Produto não encontrado com id: " + id);
        }
    }
}