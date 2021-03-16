package com.payment.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.payment.entity.Permissao;
import com.payment.payment.entity.Usuario;
import com.payment.payment.service.PermissaoService;

@RestController
@RequestMapping("/permissao")
public class PermissaoController {
	
	@Autowired
	PermissaoService service;
	
	@Secured("ROLE_ADMINISTRADOR")
	@PutMapping("/associar/{usuario}/{permissao}")
	public void associar(@PathVariable("usuario") Long idUsuario, @PathVariable("permissao") Long idPermissao) {
		Permissao permissao = service.obter(idPermissao);
		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);
		
		permissao.getUsuario().add(usuario);
		service.atualizar(permissao);
	}

}
