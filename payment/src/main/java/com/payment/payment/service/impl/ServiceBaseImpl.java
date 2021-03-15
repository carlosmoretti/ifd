package com.payment.payment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.payment.payment.entity.EntityBase;
import com.payment.payment.service.ServiceBase;

@Service
public abstract class ServiceBaseImpl<E extends EntityBase, T>
	implements ServiceBase<E, T> {
	
	public abstract JpaRepository<E, T> getRepository();

	@Override
	public List<E> obterTodos() {
		// TODO Auto-generated method stub
		return getRepository().findAll();
	}

	@Override
	public E obter(T id) {
		// TODO Auto-generated method stub
		return getRepository().findById(id)
				.orElse(null);
	}

	@Override
	public void remover(E obj) {
		// TODO Auto-generated method stub
		getRepository().delete(obj);
	}

	@Override
	public void remover(List<E> obj) {
		// TODO Auto-generated method stub
		getRepository().deleteAll(obj);
	}

	@Override
	public void cadastrar(E obj) {
		// TODO Auto-generated method stub
		getRepository().save(obj);
	}

	@Override
	public void cadastrar(List<E> obj) {
		// TODO Auto-generated method stub
		getRepository().saveAll(obj);
	}

	@Override
	public void atualizar(List<E> obj) {
		// TODO Auto-generated method stub
		getRepository().saveAll(obj);
	}

	@Override
	public void atualizar(E obj) {
		// TODO Auto-generated method stub
		getRepository().save(obj);
	}
	
}
