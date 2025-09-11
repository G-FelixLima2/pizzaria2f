package com.itb.inf2fm.pizzaria2f.model.repository;

import com.itb.inf2fm.pizzaria2f.model.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
