package com.payment.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.payment.payment.entity.Pagamento;
import com.payment.payment.repository.PagamentoRepository;
import com.payment.payment.service.PagamentoService;

@Service
public class PagamentoServiceImpl
	extends ServiceBaseImpl<Pagamento, Long>
	implements PagamentoService {
	
	@Autowired
	PagamentoRepository repository;

	@Override
	public JpaRepository<Pagamento, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}
