package com.payment.payment.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class Usuario extends EntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USU_CD_ID")
	private Long id;
	
	@Column(name = "USU_TX_NOME")
	private String nome;
	
	@Column(name = "USU_TX_SOBRENOME")
	private String sobrenome;
	
	@Column(name = "USU_TX_CPF")
	private String cpf;
	
	@Column(name = "USU_TX_EMAIL")
	private String email;
	
	@Column(name = "USU_TX_USERNAME")
	private String username;
	
	@Column(name = "USU_TX_PASSWORD")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "USUARIO_PERMISSAO",
			joinColumns = @JoinColumn(name = "USU_CD_ID"),
			inverseJoinColumns = @JoinColumn(name = "PERM_CD_ID"))
	List<Permissao> permissao;
	
}
