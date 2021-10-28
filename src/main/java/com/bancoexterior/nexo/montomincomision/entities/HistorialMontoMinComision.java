package com.bancoexterior.nexo.montomincomision.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"HISTORIAL_MONTO_MIN_COMISION\"", schema = "\"dbo\"")
public class HistorialMontoMinComision {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "USUARIO")
	@Size(max = 50)
	private String usuario;
	
	@Column(name = "DESCRIPCION")
	@Size(max = 50)
	private String descripcion;
	
	@Column(name = "MONTO")
	private BigDecimal monto;
	
	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss.SSSSSS")
	private Date fecha;
	
}
