package com.payment.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.payment.entity.Permissao;
import com.payment.payment.entity.Usuario;
import com.payment.payment.service.PermissaoService;
import com.payment.payment.service.ServiceBase;

@RestController
@RequestMapping("/permissao")
public class PermissaoController
	extends BaseController<Permissao, Long>{
	
	@Autowired
	PermissaoService service;

	@Override
	ServiceBase<Permissao, Long> getServiceBase() {
		// TODO Auto-generated method stub
		return service;
	}
	
	@PutMapping("/associar/{usuario}/{permissao}")
	public void associar(@PathVariable("usuario") Long idUsuario, @PathVariable("permissao") Long idPermissao) {
		Permissao permissao = service.obter(idPermissao);
		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);
		
		permissao.getUsuario().add(usuario);
		service.atualizar(permissao);
	}

}
