package com.bancoexterior.nexo.montomincomision.model;

import java.util.ArrayList;
import java.util.List;

import com.bancoexterior.nexo.montomincomision.entities.MontoMinComision;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Data 
@AllArgsConstructor
@Builder
public class MontoMinComisionConsultasResponse {

	@JsonProperty("resultado")
	private Resultado resultado;
	
	@JsonProperty("comisiones")
	private List<MontoMinComision> comisiones;
	
	public MontoMinComisionConsultasResponse() {
		this.resultado = new Resultado();
		this.comisiones = new ArrayList<>();
	}
}
