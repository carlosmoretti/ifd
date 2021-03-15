package com.payment.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.payment.dto.AuthenticationRequestDto;
import com.payment.payment.entity.Usuario;
import com.payment.payment.service.impl.UserDetailServiceImpl;
import com.payment.payment.util.JwtUtil;

@RestController
@RequestMapping("/autenticar")
public class AutenticarController {
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailServiceImpl userDetailsService;

    @Autowired
    JwtUtil jwtUtil;
    
    @PostMapping()
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDto authenticationRequest) {
        
    	Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(jwt);

    }
}
