package com.bancoexterior.nexo.montomincomision.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bancoexterior.nexo.montomincomision.config.Codigos.CodRespuesta;
import com.bancoexterior.nexo.montomincomision.config.Codigos.Constantes;
import com.bancoexterior.nexo.montomincomision.config.Codigos.Servicios;
import com.bancoexterior.nexo.montomincomision.entities.HistorialMontoMinComision;
import com.bancoexterior.nexo.montomincomision.model.HistorialMontoMinComisionConsultasResponse;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionConsultasRequest;
import com.bancoexterior.nexo.montomincomision.model.Resultado;
import com.bancoexterior.nexo.montomincomision.repository.IHistorialMontoMinComisionRepository;

@Service
public class HistorialMontoMinComisionServiceImpl implements IHistorialMontoMinComisionService{

	private static final Logger LOGGER = LogManager.getLogger(HistorialMontoMinComisionServiceImpl.class);
	
	@Autowired
	private IHistorialMontoMinComisionRepository repo;
	
	@Autowired
	private Environment env;
	
	
	
	/**
     * Nombre:                 findAll
     * Descripcion:            Consulta lista de HISTORIAL_MONTO_MIN_COMISION en BD (TODOS).
     *
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	@Override
	public List<HistorialMontoMinComision> findAll() {
		return repo.findAll();
	}

	
	/**
     * Nombre:                 consultaHistorialMontoMinComision
     * Descripcion:            Consulta lista de HISTORIAL_MONTO_MIN_COMISION en BD (TODOS).
     *
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	@Override
	public List<HistorialMontoMinComision> consultaHistorialMontoMinComision() {
		return repo.consultaHistorialMontoMinComision();
	}

	
	/**
     * Nombre:                 consulta
     * Descripcion:            Consulta lista de HISTORIAL_MONTO_MIN_COMISION en BD.
     *
     * @param  request MontoMinComisionConsultasRequest 
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	@Override
	public HistorialMontoMinComisionConsultasResponse consulta(MontoMinComisionConsultasRequest request) {
		LOGGER.info(Servicios.HISTORIALMONTOMINCOMISIONSERVICEI);
		HistorialMontoMinComisionConsultasResponse response = new HistorialMontoMinComisionConsultasResponse();
		List<HistorialMontoMinComision> listaHistorialMontoMinComision;
		Resultado resultado = new Resultado();
		String codigo = CodRespuesta.C0000;
		String errorCM = Constantes.BLANK;
		
		try {
			listaHistorialMontoMinComision = repo.consultaHistorialMontoMinComision();
			response.setComisiones(listaHistorialMontoMinComision);
			resultado = validaConsulta(listaHistorialMontoMinComision);
			codigo = resultado.getCodigo();
			errorCM = resultado.getDescripcion();
		} catch (Exception e) {
			LOGGER.error(e);
			codigo = CodRespuesta.CME6000;
			errorCM = Constantes.EXC+e;
		}
		response.getResultado().setCodigo(codigo);
		response.getResultado().setDescripcion(env.getProperty(Constantes.RES+codigo,codigo).replace(Constantes.ERROR, errorCM));
		LOGGER.info(response);
		LOGGER.info(Servicios.HISTORIALMONTOMINCOMISIONSERVICEF);
		return response;
	}
	
	
	/**
     * Nombre:                 validaConsulta
     * Descripcion:            Valida si la Lista trajo datos.
     *
     * @param  listaHistorialMontoMinComision List<HistorialMontoMinComision> 
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	private Resultado validaConsulta(List<HistorialMontoMinComision> listaHistorialMontoMinComision) {
		Resultado resultado = new Resultado();
		resultado.setCodigo(CodRespuesta.C0000);
		resultado.setDescripcion(Constantes.BLANK);
		
		if(listaHistorialMontoMinComision.isEmpty()) {
			resultado.setCodigo(CodRespuesta.C0001);
			return resultado;
		}
	    
		LOGGER.info(resultado);
		return resultado;
		
	}
	

}
