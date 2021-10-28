package com.bancoexterior.nexo.montomincomision.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bancoexterior.nexo.montomincomision.entities.MontoMinComision;
import com.bancoexterior.nexo.montomincomision.model.Filtros;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionConsultasRequest;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionConsultasResponse;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionRequest;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionResponse;

public interface IMontoMinComisionService {

	public List<MontoMinComision> listaMontoComision();
	
	public List<MontoMinComision> consultaMontoMinComision(Filtros filtros);
	
	public MontoMinComisionConsultasResponse consulta(MontoMinComisionConsultasRequest request);
	
	public boolean existsById(int id);
	
	public MontoMinComisionResponse actualizar(MontoMinComisionRequest request, HttpServletRequest requestHTTP);
	
	public int updateMontoMinComision(BigDecimal monto, String descripcion, String usuario, int id);
}
