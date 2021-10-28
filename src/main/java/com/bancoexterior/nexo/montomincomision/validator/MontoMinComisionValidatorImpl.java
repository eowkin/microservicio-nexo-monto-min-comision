package com.bancoexterior.nexo.montomincomision.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bancoexterior.nexo.montomincomision.exception.IdMontoMinComisionNoExistException;
import com.bancoexterior.nexo.montomincomision.model.MontoMinComisionRequest;
import com.bancoexterior.nexo.montomincomision.service.IMontoMinComisionService;
import com.bancoexterior.nexo.montomincomision.config.Codigos.CodRespuesta;


@Component
public class MontoMinComisionValidatorImpl implements IMontoMinComisionValidator{

	@Autowired
	private IMontoMinComisionService montoMinComisionService;
	
	@Override
	public void validarActualizar(MontoMinComisionRequest request) {
		if(!montoMinComisionService.existsById(request.getComision().getId())) {
			throw new IdMontoMinComisionNoExistException(CodRespuesta.CME2000);
		}
		
	}

}
