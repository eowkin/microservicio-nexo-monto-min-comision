package com.bancoexterior.nexo.montomincomision.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data 
@AllArgsConstructor 
@Builder
public class MontoMinComisionResponse {

	@JsonProperty("resultado")
	private Resultado resultado;
	
	public MontoMinComisionResponse() {
		this.resultado = new Resultado();
	}
}
