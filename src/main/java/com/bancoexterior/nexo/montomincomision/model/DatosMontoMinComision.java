package com.bancoexterior.nexo.montomincomision.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.bancoexterior.nexo.montomincomision.annotation.ANumberValidate;
import com.bancoexterior.nexo.montomincomision.config.Codigos.CodRespuesta;
import com.bancoexterior.nexo.montomincomision.config.Codigos.ParamConfig;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class DatosMontoMinComision {

	@JsonProperty("id")
	@NotNull(message= CodRespuesta.CDE1004)
    private Integer id;
	
	@JsonProperty("monto")
	@ANumberValidate(message= CodRespuesta.CDE1007, min=0.01, max = 999999999999.99, decimales=2)
	private BigDecimal monto;
	
	@JsonProperty("descripcion")
	@NotEmpty(message=CodRespuesta.CDE1005)
	@Pattern(regexp=ParamConfig.DESCRIPCION, message=CodRespuesta.CDE1005)
	private String descripcion;
	
	@JsonProperty("usuario")
	@NotEmpty(message=CodRespuesta.CDE1006)
	@Pattern(regexp=ParamConfig.USUARIO, message=CodRespuesta.CDE1006)
	private String usuario;
	
}
