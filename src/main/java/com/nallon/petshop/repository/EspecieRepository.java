package com.nallon.petshop.repository;

import com.nallon.petshop.domain.Especie;
import com.nallon.petshop.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {

}
