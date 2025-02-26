package io.github.cursoSpringBoot.Project.API.controller;

import io.github.cursoSpringBoot.Project.API.modol.Produto;
import io.github.cursoSpringBoot.Project.API.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @PostMapping
    public List<Produto> salvar(@RequestBody List<Produto> produtos) {
        produtos.forEach(produto -> {
            var id = UUID.randomUUID().toString();
            produto.setId(id);
            System.out.println("Produto recebido: " + produto);
            produtoRepository.save(produto);
        });
        return produtos;
    }
    @GetMapping("{codigo}")
    public Produto obterPorId(@PathVariable("codigsso") String id){
        // Optional<Produto> produto = produtoRepository.findById(id);
        //return produto.isPresent() ? produto.get() : null;
        return produtoRepository.findById(id).orElse(null);
    }
    @DeleteMapping("{codigo}")
    public void deletar(@PathVariable("codigo") String id){
        produtoRepository.deleteById(id);
    }
    @PutMapping("{codigo}")
    public void atualizar (@PathVariable("codigo") String id,
                           @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }
}
