package com.itb.inf2fm.pizzaria2f.controller;

import com.itb.inf2fm.pizzaria2f.model.entity.Produto;
import com.itb.inf2fm.pizzaria2f.model.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;


/*
ResponseEntity: Toda resposta HTTP (Status, cabeçalho e corpo), aqui teremos mais controle sobre o que é devolvido
                Para o cliente
1.Status HTTP: (200 ok, 201 CREATED, 404 NOT FOUND etc...)
2.Headers: (cabeçalhos, extras, como Location, Authorization etc...)
3.Body: (o objeto que será convertido em JSON/XMl para o cliente)

@RequestBody: Corpo da requisição (Recebendo um objeto JSON)

*/

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {

        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(produtoService.findById(Long.parseLong(id)));
        }catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(
              Map.of(
                      "status", 400,
                      "error",  "Bad Request",
                      "message","O id informado não é válido: " + id
              )
            );
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(404).body (
                    Map.of(
                            "status", 404,
                            "error",  "Not Found",
                            "message","Produto não encontrado com o id: " + id
                    )
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaProduto(@PathVariable String id, @RequestBody Produto produto) {
        try {
            return ResponseEntity.ok(produtoService.update(Long.parseLong(id), produto));
        }catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "status", 400,
                            "error",  "Bad Request",
                            "message","O id informado não é válido: " + id
                    )
            );
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(404).body (
                    Map.of(
                            "status", 404,
                            "error",  "Not Found",
                            "message","Produto não encontrado com o id: " + id
                    )
            );
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduto(@PathVariable String id) {
        try {
            produtoService.delete(Long.parseLong(id));
            return ResponseEntity.ok().body("Produto com o id " + id + " excluido com sucesso!");
        }catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "status", 400,
                            "error",  "Bad Request",
                            "message","O id informado não é válido: " + id
                    )
            );
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(404).body (
                    Map.of(
                            "status", 404,
                            "error",  "Not Found",
                            "message","Produto não encontrado com o id: " + id
                    )
            );
        }
    }

}