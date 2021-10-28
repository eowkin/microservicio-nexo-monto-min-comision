package com.bancoexterior.nexo.montomincomision.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bancoexterior.nexo.montomincomision.config.Codigos.CodRespuesta;
import com.bancoexterior.nexo.montomincomision.config.Codigos.Constantes;
import com.bancoexterior.nexo.montomincomision.entities.MontoMinComision;
import com.bancoexterior.nexo.montomincomision.model.Filtros;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionConsultasRequest;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionConsultasResponse;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionRequest;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionResponse;
import com.bancoexterior.nexo.montomincomision.model.Resultado;
import com.bancoexterior.nexo.montomincomision.repository.IMontoMinComisionRepository;
import com.bancoexterior.nexo.montomincomision.config.Codigos.Servicios;
import com.bancoexterior.nexo.montomincomision.interfase.IRegistrarAuditoriaService;
import com.bancoexterior.nexo.montomincomision.model.RegistrarAuditoriaRequest;

@Service
public class MontoMinComisionServiceImpl implements IMontoMinComisionService{

	private static final Logger LOGGER = LogManager.getLogger(MontoMinComisionServiceImpl.class);
	
	@Autowired
	private IMontoMinComisionRepository repo;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private IRegistrarAuditoriaService registrarA;
	
	/**
     * Nombre:                 listaMontoComision
     * Descripcion:            Consulta lista de MONTO_MIN_COMISION en BD (TODOS).
     *
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	@Override
	public List<MontoMinComision> listaMontoComision() {
		return repo.findAll();
	}

	/**
     * Nombre:                 consultaMontoMinComision
     * Descripcion:            Consulta lista de MONTO_MIN_COMISION en BD por filtro.
     *
     * @param  filtros Filtros  
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	@Override
	public List<MontoMinComision> consultaMontoMinComision(Filtros filtros) {
		
		int id = 0;
		
		if(filtros.getId() != null) {
			id = filtros.getId();
		}
		return repo.consultaMontoMinComision(id);
	}

	/**
     * Nombre:                 consulta
     * Descripcion:            Consulta lista de MONTO_MIN_COMISION en BD.
     *
     * @param  request MontoMinComisionConsultasRequest 
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	@Override
	public MontoMinComisionConsultasResponse consulta(MontoMinComisionConsultasRequest request) {
		LOGGER.info(Servicios.MONTOMINCOMISIONCONSULTASERVICEI);
		MontoMinComisionConsultasResponse response = new MontoMinComisionConsultasResponse();
		List<MontoMinComision> listaMontoMinComision;
		Resultado resultado = new Resultado();
		String codigo = CodRespuesta.C0000;
		String errorCM = Constantes.BLANK;
		
		
		try {
			listaMontoMinComision = consultaMontoMinComision(request.getComision());
			response.setComisiones(listaMontoMinComision);
			resultado = validaConsulta(listaMontoMinComision);
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
		LOGGER.info(Servicios.MONTOMINCOMISIONCONSULTASERVICEF);
		return response;
	}
	
	
	/**
     * Nombre:                 validaConsulta
     * Descripcion:            Valida si la Lista trajo datos.
     *
     * @param  listaMontoMinComision List<MontoMinComision>
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	private Resultado validaConsulta(List<MontoMinComision> listaMontoMinComision) {
		Resultado resultado = new Resultado();
		resultado.setCodigo(CodRespuesta.C0000);
		resultado.setDescripcion(Constantes.BLANK);
		
		if(listaMontoMinComision.isEmpty()) {
			resultado.setCodigo(CodRespuesta.C0001);
			return resultado;
		}
	    
		LOGGER.info(resultado);
		return resultado;
		
	}


	@Override
	public boolean existsById(int id) {
		return repo.existsById(id);
	}


	
	
	/**
     * Nombre:                 actualizar
     * Descripcion:            Actualizar MONTO_MIN_COMISION en BD.
     *
     * @param  request Objeto MontoMinComisionRequest
     * @param  request Objeto HTTPHttpServletRequest
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	@Override
	public MontoMinComisionResponse actualizar(MontoMinComisionRequest request, HttpServletRequest requestHTTP) {
		LOGGER.info(Servicios.MONTOMINCOMISIONACTUALIZARSERVICEI);
		MontoMinComisionResponse response = new MontoMinComisionResponse();
		Resultado resultado = new Resultado();
		String codigo = CodRespuesta.C0000;
		String errorCM = Constantes.BLANK;
		String microservicio = Servicios.MONTOMINCOMISIONACTUALIZAR;
		
		RegistrarAuditoriaRequest reAU = null;
		reAU = new RegistrarAuditoriaRequest(request, microservicio, requestHTTP);
		try {
			int valor = updateMontoMinComision(request.getComision().getMonto(), request.getComision().getDescripcion(),
					request.getComision().getUsuario(),  request.getComision().getId());
			
			if(valor == 0) {
				codigo = CodRespuesta.C0001;	
			}
			
			
		} catch (Exception e) {
			LOGGER.error(e);
			codigo = CodRespuesta.CME6000;
			errorCM = Constantes.EXC+e;
		}
		response.getResultado().setCodigo(codigo);
		response.getResultado().setDescripcion(env.getProperty(Constantes.RES+codigo,codigo).replace(Constantes.ERROR, errorCM));
		
		resultado.setCodigo(codigo);
		resultado.setDescripcion(env.getProperty(Constantes.RES+codigo,codigo).replace(Constantes.ERROR, errorCM));
		reAU.setIdCliente(Constantes.RIF);
		reAU.setCedula(Constantes.CEDULA);
		reAU.setTelefono(Constantes.TELEFONO);
		reAU.setIdCanal(request.getCanalCM());
		registrarAuditoriaBD(reAU, resultado, errorCM);
		LOGGER.info(response);
		LOGGER.info(Servicios.MONTOMINCOMISIONACTUALIZARSERVICEF);
		return response;
	}


	@Override
	public int updateMontoMinComision(BigDecimal monto, String descripcion, String usuario, int id) {
		return repo.updateMontoMinComision(monto, descripcion, usuario, id);
	}
	
	
	
	
	/**
     * Nombre:                 registrarAuditoriaBD
     * Descripcion:            Registrar Auditoria en Web Service
     *
     * @param  registrarAu  Objeto RegistrarAuditoriaRequest
     * @param  response   Objeto Resultado
     * @param errorAdicional Descripcion del error
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
	 */
	private void registrarAuditoriaBD(RegistrarAuditoriaRequest registrarAu,Resultado response, String errorAdicional) {
			
		        registrarA.registrarAuditoria(registrarAu, response.getCodigo(),response.getDescripcion(),errorAdicional);	
	}

}
