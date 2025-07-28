package com.itb.inf2fm.pizzaria2f.controller;

import com.itb.inf2fm.pizzaria2f.model.entity.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    List<Produto> produtos = new ArrayList<Produto>();

    @GetMapping
    public List<Produto> findAll() {

        Produto p1 = new Produto();
        p1.setNome("Pizza de Calabreso");
        p1.setDescricao("Pizza de Calabreso com bastante cebola");
        p1.setValorVenda(49.90);

        // Crie mais um produto e adicione á lista de produtos

        Produto p2 = new Produto();
        p2.setNome("Pizza de Mussarello");
        p2.setDescricao("Pizza de Mussarello com quiejo até demais");
        p2.setValorVenda(69.96);

        // Adicionando o produto à lista

        produtos.add(p1);
        produtos.add(p2);

        return produtos;
    }

}
