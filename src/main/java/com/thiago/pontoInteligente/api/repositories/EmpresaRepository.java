package com.thiago.pontoInteligente.api.repositories;



import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thiago.pontoInteligente.api.entities.Empresa;

@Repository
public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, Long>, JpaSpecificationExecutor<Empresa> {
	
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);

}
