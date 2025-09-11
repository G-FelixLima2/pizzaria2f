package com.itb.inf2fm.pizzaria2f.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Telefone")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 5, nullable = false)
    private String ddd;
    @Column(length = 15, nullable = true)
    private String numero;
    private boolean codStatus;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    public String getDdd() {
        return ddd;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setCodStatus(boolean codStatus) {
        this.codStatus = codStatus;
    }

    public boolean getCodStatus() {
        return codStatus;
    }

}
