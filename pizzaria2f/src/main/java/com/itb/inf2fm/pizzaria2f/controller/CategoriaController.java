package com.itb.inf2fm.pizzaria2f.controller;
import com.itb.inf2fm.pizzaria2f.model.entity.Categoria;
import com.itb.inf2fm.pizzaria2f.model.entity.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")

public class CategoriaController {
    List<Categoria> categoria = new ArrayList<Categoria>();

    @GetMapping
    public List<Categoria> findAll() {
        Categoria cat1 = new Categoria();
        cat1.setNome("Pizza");
        cat1.setDecricao("Prato de massa cheio de furunfufum com broda recheada ou não.");

        categoria.add(cat1);

        return categoria;
    }

}
