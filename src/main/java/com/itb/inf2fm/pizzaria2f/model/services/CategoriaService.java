package com.itb.inf2fm.pizzaria2f.model.services;

import com.itb.inf2fm.pizzaria2f.model.entity.Categoria;
import com.itb.inf2fm.pizzaria2f.model.entity.Produto;
import com.itb.inf2fm.pizzaria2f.model.repository.CategoriaRepository;
import com.itb.inf2fm.pizzaria2f.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar Categorias
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    //Salvar categoria
    public Categoria save(Categoria categoria) {
        categoria.setCod_status(true);
        return categoriaRepository.save(categoria);
    }

    //Lisat categorias por ID
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Categoria não encontrada com id" + id));
    }

    //Atualizar Categoria
    public Categoria update(Long id, Categoria categoria) {
        Categoria categoriaExistente = findById(id);
        categoriaExistente.setNome(categoria.getNome());
        categoriaExistente.setDecricao(categoria.getDecricao());
        return categoriaRepository.save(categoriaExistente);
    }

    //Excluir Categoria
    public void delete(Long id) {
        Categoria categoriaExistente = findById(id);
        categoriaRepository.delete(categoriaExistente);
    }
}

