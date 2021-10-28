package com.bancoexterior.nexo.montomincomision.model;

import java.util.ArrayList;
import java.util.List;

import com.bancoexterior.nexo.montomincomision.entities.HistorialMontoMinComision;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data 
@AllArgsConstructor
@Builder
public class HistorialMontoMinComisionConsultasResponse {

	@JsonProperty("resultado")
	private Resultado resultado;
	
	@JsonProperty("comisiones")
	private List<HistorialMontoMinComision> comisiones;
	
	public HistorialMontoMinComisionConsultasResponse() {
		this.resultado = new Resultado();
		this.comisiones = new ArrayList<>();
	}
}
