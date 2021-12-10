package com.thiago.pontoInteligente.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.thiago.pontoInteligente.api.enums.TipoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_lancamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "localizacao")
	private String localizacao;
	@Column(name = "data_criacao")
	private Date dataCriacao;
	@Column(name = "dataAtualizacao")
	private Date dataAtualizacao;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoEnum tipo;
	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;
	
}
