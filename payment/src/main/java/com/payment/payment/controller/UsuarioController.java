package com.payment.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.payment.entity.Usuario;
import com.payment.payment.service.ServiceBase;
import com.payment.payment.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController 
	extends BaseController<Usuario, Long> {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	ServiceBase<Usuario, Long> getServiceBase() {
		// TODO Auto-generated method stub
		return service;
	}
	
	@Override
	public void adicionar(@RequestBody Usuario obj) {
		// TODO Auto-generated method stub
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		super.adicionar(obj);
	}
	
	@Override
	public void atualizar(@RequestBody Usuario obj) {
		// TODO Auto-generated method stub
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		super.atualizar(obj);
	}
}
