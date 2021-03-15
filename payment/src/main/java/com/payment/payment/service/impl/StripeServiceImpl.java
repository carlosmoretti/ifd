package com.payment.payment.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.payment.payment.service.StripeService;

public class StripeServiceImpl
	implements StripeService {
	
	@Value("${stripe.secret}")
	private String api;
	
	
}
