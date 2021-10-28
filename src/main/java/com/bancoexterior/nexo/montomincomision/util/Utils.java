package com.bancoexterior.nexo.montomincomision.util;


import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bancoexterior.nexo.montomincomision.config.Codigos.Constantes;


@Service
public class Utils {
	
	private static final Logger LOGGER = LogManager.getLogger(Utils.class);
	private static final String DIASDEFAULT ="1";
	
	private Utils() {
		super();
	}
	
	/**
     * Nombre:                  getHttpStatus
     * Descripcion:             Obtener Status HTTP cuando la peticion dio resultado incorrecto
     * 
     * @param  codigo codigo de respuesta
     * @return  HttpStatus estatus Http
     * @version 1.0
     * @author Wilmer Vieira
	 * @since 08/06/20
     */
	public static HttpStatus getHttpStatus(String codigo) {
		
	
		try {
		  String cod = codigo.substring(0, 1);
	
	
		switch (cod) {
		case Constantes.SUBSTRING_COD_OK:
			return HttpStatus.OK;
			
		case Constantes.SUBSTRING_COD_UNPROCESSABLE_ENTITY:
			return HttpStatus.UNPROCESSABLE_ENTITY;
			
		case Constantes.INTERNAL_SERVER_ERROR:
			return HttpStatus.INTERNAL_SERVER_ERROR;		

		default:
			return HttpStatus.BAD_REQUEST;
			
		}
		
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return HttpStatus.BAD_REQUEST;
		}
		
		
	}
	
	/**
     * Nombre:                  validaFormatoFecha
     * Descripcion:             Valida formato de la fecha
     *
     * @param  String Fecha a validar 
     * @param String Formato de la fecha
     * @return boolean  true  = Formato y fecha coinciden
     * 				    false = Formato y fecha NO coinciden
     * @version 1.0
     * @author Wilmer Vieira
	 * @since 16/03/21
     */
		
	public static boolean validaFormatoFecha(String fechaValidar, String formato ) {
		
		try {
		      // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
		      LocalDate.parse(fechaValidar,DateTimeFormatter.ofPattern(formato)
		    		   .withResolverStyle(ResolverStyle.STRICT));
		      return true;
		      } catch (DateTimeParseException e) {
		    	  LOGGER.info(e);
		          return false;
		      }
	}
	
	/**
     * Nombre:                  generateCorrelationId
     * Descripcion:             Obtener codigo aleatorio
     * 
     * @return  CorrelationId Generado
     * @version 1.0
     * @author Wilmer Vieira
	 * @since 07/07/20
     */
	
	public static String generateCorrelationId() {
		byte[] bytes = new byte[12];
		SecureRandom random = new SecureRandom();
		random.nextBytes(bytes);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String theHex = Integer.toHexString(bytes[i] & 0xFF).toUpperCase();
			sb.append(theHex.length() == 1 ? "0" + theHex : theHex);
		}
		
		return sb.toString();
	}
	
	/**
     * Nombre:                  fechaOut
     * Descripcion:             Obtener fecha/hora actual segun el formato deseado
     *
     * @param  format  formato deseado para la fecha
     * @return String  fecha actual con el formato deseado
     * @version 1.0
     * @author Wilmer Vieira
	 * @since 08/06/20
     */
	public static String fechaOut(String format) {
		String dateString = null;
		DateFormat formatof = new SimpleDateFormat(format);
		dateString = formatof.format(new Date());
		return dateString;
	}
	
	public static String getTipoCliente(String nroIdCliente) {
		
		 String cod = nroIdCliente.substring(0, 1).toUpperCase();
		
		 switch (cod) {
		    case "V": case "E": case "P":
		    	return "N";
		default:
			   return "J";
		}
		
	
	}
	
	/**
     * Nombre:                  fechaOut
     * Descripcion:             Obtener fecha/hora segun el formato deseado
     *
     * @param  format  formato deseado para la fecha
     * @return String  fecha actual con el formato deseado
     * @version 1.0
     * @author Wilmer Vieira
	 * @since 08/06/20
     */
	public static String fechaOutFormat(Date date,String format) {
		String dateString = null;
		DateFormat formatof = new SimpleDateFormat(format);
		dateString = formatof.format(date);
		return dateString;
	}
	
	
	
	
	
	/**
     * Nombre:                  validar
     * Descripcion:             Validar campos del request
     *
     * @param  text Texto a validar 
     * @param regex Regla de validación
     * @return boolean 
     * @version 1.0
     * @author Wilmer Vieira
	 	* @since 01/07/20
     */
	
	public static boolean validar(String text,String regex) {
		
		if(text == null) {
			text=Constantes.BLANK;
		}
		
		 Pattern pattern = Pattern.compile(regex);
		    Matcher matcher = pattern.matcher(text);
		    int matches = 0;
		    while (matcher.find()) {
		        matches++;
		    }
		    
		    return (matches!=0);
		   
	}
	
	
	
	/**
     * Nombre:                  validaCaracteresMonto
     * Descripcion:             Validar cantidad caracteres del monto
     *
     * @param  monto Monto a evaluar
     * @return boolean 
     * @version 1.0
     * @author Wilmer Vieira
	 * @since 28/04/21
     */
	   public static boolean validaCaracteresMonto(String monto) {
		   
		   return (monto.length()<=15);
		   
	   }
	   
	     
	  /**
	     * Nombre:                  parseInteger
	     * Descripcion:             Transformar String a Entero
	     *
	     * @param  String integer = numero
	     * @return Integer
	     * @version 1.0
	     * @author Wilmer Vieira
		 * @since 17/05/21
	     */
	  
	  public static Integer parseInteger(String integer) {
		  
		  try {
			  return Integer.parseInt(integer);
		} catch (Exception e) {
			LOGGER.error(e);
			LOGGER.error(integer);
			return 1;
		}
		  
	  }
	  
	  /**
	     * Nombre:                  validInteger
	     * Descripcion:             Validar si un String es un numero entero
	     *
	     * @param  String integer = numero
	     * @return String = mismo valor si la operacion es OK, 1, si esta mal.
	     * @version 1.0
	     * @author Wilmer Vieira
		 * @since 17/05/21
	     */
   public static String validInteger(String valor) {
		  
		  try {
			  Integer.parseInt(valor);
			  return valor;
		} catch (Exception e) {
			LOGGER.error(e);
			LOGGER.error(valor);
			return  DIASDEFAULT;
		}
		  
	  }
   
   
   public static TrustManager  trustSelfSignedSSLWS() {
		X509Certificate[] xCertificate = null;
		

	    return new X509TrustManager() {

	        public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
	        	
	        	if (string.equalsIgnoreCase(Constantes.BLANK)) {
	    			throw new CertificateException();
	    		}
	        }

	        public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
	        
	        	if (string.equalsIgnoreCase(Constantes.BLANK)) {
	    			throw new CertificateException();
	    		}
	        
	        }

	        public X509Certificate[] getAcceptedIssuers() {

	            return xCertificate;
	        }
	    };
	 
	}
   
   
  

}
