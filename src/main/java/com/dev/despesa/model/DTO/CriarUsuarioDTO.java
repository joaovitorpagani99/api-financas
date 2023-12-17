package com.dev.despesa.model.DTO;

import com.dev.despesa.model.Enum.RolesNome;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CriarUsuarioDTO(

		@NotBlank String nome,

		@Email String email,

		@NotBlank String senha,
		RolesNome role) {
}
