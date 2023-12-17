package com.dev.despesa.model.DTO;

import jakarta.validation.constraints.Email;

public record LoginDTO(
		@Email String email,
		String senha) {

}
