package com.payment.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.payment.payment.entity.Permissao;
import com.payment.payment.repository.PermissaoRepository;
import com.payment.payment.service.PermissaoService;

@Service
public class PermissaoServiceImpl
	extends ServiceBaseImpl<Permissao, Long>
	implements PermissaoService {
	
	@Autowired
	PermissaoRepository repository;

	@Override
	public JpaRepository<Permissao, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}
