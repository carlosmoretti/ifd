package com.payment.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.payment.payment.entity.Usuario;
import com.payment.payment.repository.UsuarioRepository;
import com.payment.payment.service.UsuarioService;

@Service
public class UsuarioServiceImpl
	extends ServiceBaseImpl<Usuario, Long>
	implements UsuarioService {
	
	@Autowired
	UsuarioRepository repository;

	@Override
	public JpaRepository<Usuario, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
