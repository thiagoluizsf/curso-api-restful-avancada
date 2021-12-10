package com.thiago.pontoInteligente.api.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.thiago.pontoInteligente.api.entities.Lancamento;

@Repository
public interface LancamentoRepository extends PagingAndSortingRepository<Lancamento, Long>, JpaSpecificationExecutor<Lancamento> {

}
