package com.payment.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestDto {
	private String username;
	private String password;
}
