package com.bancoexterior.nexo.montomincomision.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bancoexterior.nexo.montomincomision.config.Codigos.Constantes;
import com.bancoexterior.nexo.montomincomision.model.CustromErrorResponse;
import com.bancoexterior.nexo.montomincomision.model.ResponseBad;
import com.bancoexterior.nexo.montomincomision.util.Utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@Autowired
	private Environment env;
	private static final Logger LOGER = LogManager.getLogger(CustomGlobalExceptionHandler.class);	
	private CustromErrorResponse response = new CustromErrorResponse();
	private String error;
	
	/**
     * Nombre:                  handleException
     * Descripcion:             Exception Personalizada
     *
     * @param  Objeto tipo Exception
     * @return ResponseEntity<Object>  
     * @version 1.0
     * @author Wilmer Vieira
	 * @since 17/05/21
     */
	
	
	@ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> handleException(Exception ex) {
		ResponseBad errorDTO = new ResponseBad();
		String[] split;
		String codigo;
		String errorI;
		
	    split = ex.getMessage().split(Constantes.SPLITPLECA);
	    
	    codigo = split[0];
	    errorI = split.length >=1 ? split[1]: Constantes.BLANK;

        errorDTO.getResultadoBAD().setCodigo(codigo);
        errorDTO.getResultadoBAD().setDescripcion(errorI);
        LOGER.error(errorDTO);
        return new ResponseEntity<>(errorDTO, Utils.getHttpStatus(codigo));
    }
	
	
    // error handle for @Valid
	
	/**
	 * Customize the response for MethodArgumentNotValidException.
	 * <p>This method delegates to {@link #handleExceptionInternal}.
	 * @param ex the exception
	 * @param headers the headers to be written to the response
	 * @param status the selected response status
	 * @param request the current request
	 * @return a {@code ResponseEntity} instance
	 */

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
    	
    	
    	ResponseBad responseBad = new ResponseBad();
 	
        //Get all errors
    	
		List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
		

        responseBad.getResultadoBAD().setCodigo(errors.get(0));
    	responseBad.getResultadoBAD().setDescripcion(env.getProperty(Constantes.RES+errors.get(0),errors.get(0)));
    	
    	error = responseBad+((ServletWebRequest)request).getRequest().getRequestURI();
       LOGER.error(error);
       return handleExceptionInternal(ex, responseBad, headers, Utils.getHttpStatus(errors.get(0)), request);

    }
    
    /**
	 * Customize the response for HttpMessageNotReadableException.
	 * <p>This method delegates to {@link #handleExceptionInternal}.
	 * @param ex the exception
	 * @param headers the headers to be written to the response
	 * @param status the selected response status
	 * @param request the current request
	 * @return a {@code ResponseEntity} instance
	 */
    @Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		response.setStatus(status.value());
		response.setError(ex.getClass().getSimpleName());
		response.setTimestamp(new Date().toString());
		response.setMessage(ex.getMessage());
		response.setPath(((ServletWebRequest)request).getRequest().getRequestURI());
		
		error = response+((ServletWebRequest)request).getRequest().getRequestURI();
		LOGER.error(error);
	    return handleExceptionInternal(ex, response, headers, status, request);
	}
    
   
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BadRequestException.class})
    @ResponseBody
    public ResponseBad badRequest(Exception e) {
    	LOGER.info("badRequest");
    	LOGER.info(e.getMessage());
    	
    	ResponseBad responseBad = new ResponseBad();
    	responseBad.getResultadoBAD().setCodigo(e.getMessage());
    	responseBad.getResultadoBAD().setDescripcion(env.getProperty(Constantes.RES + e.getMessage(), e.getMessage()));
    	return responseBad;
    }

}
