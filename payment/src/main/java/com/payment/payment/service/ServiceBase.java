package com.payment.payment.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceBase<E, T> {
	List<E> obterTodos();
	E obter(T id);
	void remover(E obj);
	void remover(List<E> obj);
	void cadastrar(E obj);
	void cadastrar(List<E> obj);
	void atualizar(List<E> obj);
	void atualizar(E obj);
}
