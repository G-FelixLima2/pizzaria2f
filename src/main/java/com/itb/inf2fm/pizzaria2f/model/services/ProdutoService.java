package com.itb.inf2fm.pizzaria2f.model.services;

import com.itb.inf2fm.pizzaria2f.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
}
