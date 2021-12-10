package com.thiago.pontoInteligente.api.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_EMPRESA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "razao_social")
	private String razaoSocial;
	@Column(name = "cnpj")
	private String cnpj;
	@Column(name = "dataCriacao")
	private Date dataCriacao;
	@Column(name = "dataAtualizacao")
	private Date dataAtualizacao;
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Funcionario> funcionarios;
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date dataAtual = new Date();
		dataCriacao = dataAtual;
		dataAtualizacao = dataAtual;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizacao=" + dataAtualizacao + ", funcionarios=" + funcionarios + "]";
	}
}
