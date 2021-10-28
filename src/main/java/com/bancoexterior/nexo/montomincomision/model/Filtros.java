package com.bancoexterior.nexo.montomincomision.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class Filtros {
	
	@JsonProperty("id")
	private Integer id;
	

}
