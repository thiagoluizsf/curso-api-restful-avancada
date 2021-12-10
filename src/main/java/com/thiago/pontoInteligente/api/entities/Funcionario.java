package com.thiago.pontoInteligente.api.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.thiago.pontoInteligente.api.enums.PerfilEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_FUNCIONARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "email")
	private String email;
	@Column(name = "senha")
	private String senha;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "valorHora")
	private BigDecimal valorHora;
	@Column(name = "qtdHorasTrabalho")
	private float qtdHorasTrabalho;
	@Column(name = "qtdHorasAlmoco")
	private float qtdHorasAlmoco;
	@Column(name = "dataCriacao")
	private Date dataCriacao;
	@Column(name = "dataAtualizacao")
	private Date dataAtualizacao;
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil")
	public PerfilEnum perfil;
	
	@Transient
	public Optional<BigDecimal> getHoraValorOpt(){
		return Optional.ofNullable(valorHora);
	}
	
	@Transient
	public Optional<Float> getQtdHorasTrabalhoDiaOpt(){
		return Optional.ofNullable(qtdHorasTrabalho);
	}
	
	@Transient
	public Optional<Float> getQtdHorasAlmocoOpt(){
		return Optional.ofNullable(qtdHorasAlmoco);
	}
}
