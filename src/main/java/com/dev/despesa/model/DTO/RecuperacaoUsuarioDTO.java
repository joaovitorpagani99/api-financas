package com.dev.despesa.model.DTO;

import java.util.List;

import com.dev.despesa.model.Roles;

import jakarta.validation.constraints.Email;

public record RecuperacaoUsuarioDTO(
		Long id,
		
		@Email
		String email,
		List<Roles> roles) {

}
