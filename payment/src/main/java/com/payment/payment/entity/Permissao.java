package com.payment.payment.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PERMISSAO")
public class Permissao 
	extends EntityBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERM_CD_ID")
	private Long id;
	
	@Column(name = "PERM_TX_NOME")
	private String nome;
	
	@JsonIgnore()
	@ManyToMany()
	@JoinTable(
			name = "USUARIO_PERMISSAO",
			joinColumns = @JoinColumn(name = "PERM_CD_ID"),
			inverseJoinColumns = @JoinColumn(name = "USU_CD_ID"))
	Set<Usuario> usuario;
}
