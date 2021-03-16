package com.payment.payment.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.payment.payment.entity.Permissao;
import com.payment.payment.entity.Usuario;
import com.payment.payment.repository.PermissaoRepository;
import com.payment.payment.repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PermissaoRepository permissaoRepository;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		List<GrantedAuthority> roles = usuario.getPermissao().stream().map(e -> new SimpleGrantedAuthority("ROLE_" + e.getNome().toUpperCase())).collect(Collectors.toList());
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
