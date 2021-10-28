package com.bancoexterior.nexo.montomincomision.model;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.bancoexterior.nexo.montomincomision.annotation.AFechaValidate;
import com.bancoexterior.nexo.montomincomision.annotation.ANotEmptyValidate;
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
public class MontoMinComisionRequest {

	@JsonProperty("idSesion")
	@NotEmpty(message=CodRespuesta.CDE1000)
	@AFechaValidate(message=CodRespuesta.CDE1000, formato = ParamConfig.IDSESIONVALID)
	private String idSesionMR;
	
	@JsonProperty("idUsuario")
	@NotEmpty(message=CodRespuesta.CDE1001)
	@Pattern(regexp=ParamConfig.IDUSUARIO, message=CodRespuesta.CDE1001)
	private String idUsuarioMR;
	
	@JsonProperty("codUsuario")
	@NotEmpty(message=CodRespuesta.CDE1002)
	@Pattern(regexp=ParamConfig.CODUSUARIO, message=CodRespuesta.CDE1002)
	private String codUsuarioMR;
	
	@JsonProperty("canal")
	@NotEmpty(message=CodRespuesta.CDE1008)
	@Pattern(regexp=ParamConfig.CANAL, message=CodRespuesta.CDE1008)
	private String canalCM;
	
	@JsonProperty("comision")
	@Valid
	@ANotEmptyValidate(message= CodRespuesta.CDE1003)
	private DatosMontoMinComision comision;
}
