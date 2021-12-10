package com.thiago.pontoInteligente.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.pontoInteligente.api.entities.Funcionario;
import com.thiago.pontoInteligente.api.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public Funcionario findByCpf(String cpf) {
		return funcionarioRepository.findByCpf(cpf);
	}
}
