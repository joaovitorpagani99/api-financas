package com.dev.despesa.model.DTO;

import java.util.List;

import com.dev.despesa.model.Roles;

public record RecuperacaoUsuarioDTO(
		Long id,
		String email,
		List<Roles> roles) {

}
