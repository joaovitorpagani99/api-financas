package com.dev.despesa.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public record ApiErro (
		
		LocalDateTime timeStamp,
		
		Integer code,
		
		String status,
		
		List<String> erros
		
		) {
}
