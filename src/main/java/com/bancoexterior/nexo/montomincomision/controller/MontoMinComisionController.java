package com.bancoexterior.nexo.montomincomision.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bancoexterior.nexo.montomincomision.config.Codigos.Servicios;
import com.bancoexterior.nexo.montomincomision.entities.MontoMinComision;
import com.bancoexterior.nexo.montomincomision.model.HistorialMontoMinComisionConsultasResponse;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionConsultasRequest;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionConsultasResponse;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionRequest;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionResponse;
import com.bancoexterior.nexo.montomincomision.service.IHistorialMontoMinComisionService;
import com.bancoexterior.nexo.montomincomision.service.IMontoMinComisionService;
import com.bancoexterior.nexo.montomincomision.util.Utils;
import com.bancoexterior.nexo.montomincomision.validator.IMontoMinComisionValidator;
import com.bancoexterior.nexo.montomincomision.config.Codigos.Constantes;

@RestController
@RequestMapping("${microservicio.path.pre}" + "${microservicio.ambiente}")
public class MontoMinComisionController {

	private static final Logger LOGGER = LogManager.getLogger(MontoMinComisionController.class);
	
	
	@Autowired
	private IMontoMinComisionService montoMinComisionService;
	
	@Autowired
	private IHistorialMontoMinComisionService historialMontoMinComisionService;
	
	@Autowired
	private IMontoMinComisionValidator montoMinComisionValidator;
	
	
	@GetMapping(path = Servicios.MONTOMINCOMISIONURLV1
			+ "/consultas")
	public List<MontoMinComision> consulta(){
		return montoMinComisionService.listaMontoComision();
	}
	
	/**
     * Nombre:                 consultasMontoMinComision
     * Descripcion:             Invocar metodo para consultar MONTO_MIN_COMISION
     *
     * @param   request Objeto tipo MontoMinComisionConsultasRequest
     * @param  requestHTTP Objeto tipo HttpServletRequest
     * @return ResponseEntity<Object>  
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
     */
	@PostMapping(path=Servicios.MONTOMINCOMISIONURLV1+Servicios.MONTOMINCOMISIONURL+Servicios.MONTOMINCOMISIONCONSULTAURL, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object>  consultasMontoMinComision(@RequestBody @Valid MontoMinComisionConsultasRequest request,HttpServletRequest requestHTTP){
		LOGGER.info(Servicios.MONTOMINCOMISIONCONSULTACONTROLLERI);
		LOGGER.info(request);
		MontoMinComisionConsultasResponse response;
		HttpStatus estatusCM;
		
		response = montoMinComisionService.consulta(request);
		estatusCM = Utils.getHttpStatus(response.getResultado().getCodigo().trim());
		
		
		LOGGER.info(Servicios.MONTOMINCOMISIONCONSULTACONTROLLERF);
		if (response.getResultado().getCodigo().trim().substring(0, 1)
				.equalsIgnoreCase(Constantes.SUBSTRING_COD_OK)) {
			return new ResponseEntity<>(response, estatusCM);
		} else {

			return new ResponseEntity<>(response.getResultado(), estatusCM);
		}
	}
	
	/**
     * Nombre:                 actuliza
     * Descripcion:            Invocar metodo para actualizar MONTO_MIN_COMISION
     *
     * @param   request Objeto tipo MontoMinComisionRequest
     * @param  requestHTTP Objeto tipo HttpServletRequest
     * @return ResponseEntity<Object>  
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
     */
	@PutMapping(path=Servicios.MONTOMINCOMISIONURLV1+Servicios.MONTOMINCOMISIONURL, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object>  actuliza(@RequestBody @Valid MontoMinComisionRequest request,HttpServletRequest requestHTTP){
		LOGGER.info(Servicios.MONTOMINCOMISIONACTUALIZARCONTROLLERI);
		LOGGER.info(request);
		MontoMinComisionResponse response;
		HttpStatus estatusCM;
		
		montoMinComisionValidator.validarActualizar(request);
		response = montoMinComisionService.actualizar(request, requestHTTP);
		estatusCM = Utils.getHttpStatus(response.getResultado().getCodigo().trim());
		
		
		LOGGER.info(Servicios.MONTOMINCOMISIONACTUALIZARCONTROLLERF);
		if (response.getResultado().getCodigo().trim().substring(0, 1)
				.equalsIgnoreCase(Constantes.SUBSTRING_COD_OK)) {
			return new ResponseEntity<>(response, estatusCM);
		} else {

			return new ResponseEntity<>(response.getResultado(), estatusCM);
		}
	}
	
	/**
     * Nombre:                 consultasHistorialMontoMinComision
     * Descripcion:            Invocar metodo para consultar HISTORIAL_MONTO_MIN_COMISION
     *
     * @param   request Objeto tipo MontoMinComisionRequest
     * @param  requestHTTP Objeto tipo HttpServletRequest
     * @return ResponseEntity<Object>  
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 28/10/21
     */
	@PostMapping(path=Servicios.MONTOMINCOMISIONURLV1+Servicios.MONTOMINCOMISIONURL+Servicios.MONTOMINCOMISIONCONSULTAHISTORIALNURL, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object>  consultasHistorialMontoMinComision(@RequestBody @Valid MontoMinComisionConsultasRequest request,HttpServletRequest requestHTTP){
		LOGGER.info(Servicios.MONTOMINCOMISIONHISTORIALCONTROLLERI);
		LOGGER.info(request);
		HistorialMontoMinComisionConsultasResponse response;
		HttpStatus estatusCM;
		
		response = historialMontoMinComisionService.consulta(request);
		estatusCM = Utils.getHttpStatus(response.getResultado().getCodigo().trim());
		
		
		LOGGER.info(Servicios.MONTOMINCOMISIONHISTORIALCONTROLLERF);
		if (response.getResultado().getCodigo().trim().substring(0, 1)
				.equalsIgnoreCase(Constantes.SUBSTRING_COD_OK)) {
			return new ResponseEntity<>(response, estatusCM);
		} else {

			return new ResponseEntity<>(response.getResultado(), estatusCM);
		}
	}
}
