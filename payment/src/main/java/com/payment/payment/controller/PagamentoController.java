package com.payment.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.payment.payment.entity.Pagamento;
import com.payment.payment.service.PagamentoService;
import com.payment.payment.service.ServiceBase;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController 
	extends BaseController<Pagamento, Long> {
	
	@Autowired
	PagamentoService pagamentoService;

	@Override
	ServiceBase<Pagamento, Long> getServiceBase() {
		// TODO Auto-generated method stub
		return pagamentoService;
	}
}
