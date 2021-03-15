package com.payment.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.payment.entity.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
