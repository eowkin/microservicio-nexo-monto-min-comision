package com.bancoexterior.nexo.montomincomision.service;

import java.util.List;

import com.bancoexterior.nexo.montomincomision.entities.HistorialMontoMinComision;
import com.bancoexterior.nexo.montomincomision.model.HistorialMontoMinComisionConsultasResponse;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionConsultasRequest;

public interface IHistorialMontoMinComisionService {

	public List<HistorialMontoMinComision> findAll();
	
	public List<HistorialMontoMinComision> consultaHistorialMontoMinComision();
	
	public HistorialMontoMinComisionConsultasResponse consulta(MontoMinComisionConsultasRequest request);
}
