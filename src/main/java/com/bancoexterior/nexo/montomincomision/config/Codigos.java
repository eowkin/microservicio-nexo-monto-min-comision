package com.bancoexterior.nexo.montomincomision.config;

public class Codigos {

	
	public class Ambientes{
		
		private Ambientes() {
			super();
		}
		
		
		public static final String DESARROLLO = "des";
		public static final String CALIDAD    = "qa";
		public static final String PRODUCCION = "pro";
	}
	
	
	public class CodRespuesta{
		
		private CodRespuesta() {
			super();
		}
		
		//ok
		public static final String C0000 = "0000";
		public static final String C0001 = "0001";
		
		//entrada moneda
		public static final String CDE1000 = "1000";
		public static final String CDE1001 = "1001";
		public static final String CDE1002 = "1002";
		public static final String CDE1003 = "1003";
		public static final String CDE1004 = "1004";
		public static final String CDE1005 = "1005";
		public static final String CDE1006 = "1006";
		public static final String CDE1007 = "1007";
		public static final String CDE1008 = "1008";
		
		
		//entrada tasa
		public static final String CDE1009 = "1009";
		public static final String CDE1010 = "1010";
		
		//BD
		public static final String CME2000 = "2000";
		public static final String CME2001 = "2001";
		public static final String CME2005 = "2005";
		
		////GENERAL
    	public static final String CME6000 = "6000";
    	public static final String CME6001 = "6001";
		public static final String CME6002 = "6002";
		
	}
	
	
	public class FormatosString{
		
		private FormatosString() {
			super();

		}
		
		public static final String P_1S  = "%-1s";
		public static final String P2S   = "%2s";
		public static final String P3S   = "%3s";
		public static final String P6S   = "%6s";
		public static final String P_4S  = "%-4s";
		public static final String P4S  = "%4s";
		public static final String P_6S  = "%-6s";
		public static final String P_8S  = "%-8s";
		public static final String P8S   = "%8s";
		public static final String P_9S  = "%-9s";
		public static final String P9S  = "%9s";
		public static final String P_12S = "%-12s";
		public static final String P_13S = "%-13s";
		public static final String P_15S = "%-15s";
		public static final String P15S  = "%15s";
		public static final String P015S = "%015s";
		public static final String P_16S = "%-16s";
		public static final String P_14S = "%-14s";
		public static final String P_10S = "%-10s";
		public static final String P_20S = "%-20s";
		public static final String P_25S = "%-25s";
		public static final String P_30S = "%-30s";
		public static final String P_34S = "%-34s";
		public static final String P_40S = "%-40s";
		public static final String P40S  = "%40s";
		public static final String P45S  = "%45s";
		public static final String P50S  = "%50s";
		public static final String P70S  = "%70s";
	}
	
	public class Annotation{
		private Annotation() {
			super();
		}
		
		public static final String OBJECTDEFAULT     = "[Objeto vacio]";
		public static final String FECHADEFAULT      = "[Fecha invalida]";
		public static final String NUMBERDEFAULT      = "[Numero Invalido]";
	 }
	
	
	public class ParamConfig{
		private ParamConfig() {
			super();
		}
		
		public static final String CANAL           = "^[a-zA-Z\\-0-9]{1,4}$";
		public static final String IDSESIONVALID   = "uuuuMMddHHmmss";
		public static final String CODUSUARIO      = "^.{2,10}$";
		public static final String IDUSUARIO       = "^.{1,15}$";
		public static final String DESCRIPCION     = "^.{1,50}$";
		public static final String USUARIO         = "^.{1,50}$";
		
		
		
		
		public static final String CODMONEDA       = "^[a-zA-Z\\-0-9]{1,3}$";
		public static final String CODALTERNO      = "^.{1,10}$";
		public static final String MONTO           = "^\\d{1,3}(\\.?\\d{3})*(,\\d{1,2})?$";
		
	}
	
	
	public class Constantes{
		
		private Constantes() {
			super();
		}
		
		public static final int IDDEFAULT                      = 0;
		
		
		public static final String MONEDADEFAULT                      = "000";
		public static final String TRUE                               = "true";
		public static final String CODALTERNODEFAULT                  = "1234";
		public static final String BLANK                              = "";
		public static final String RES                                = "res.";
		public static final String SUBSTRING_COD_OK                   = "0";
		public static final String SUBSTRING_COD_UNPROCESSABLE_ENTITY = "1";
		public static final String INTERNAL_SERVER_ERROR              = "6";
		public static final String XCLIENTIP                          = "X-Client-IP";
		public static final String CONTENT_TYPE                       = "Content-Type";
		public static final String ACCEPT_CHARSET                     = "Accept-Charset";
		public static final String UTF8                               = "UTF-8";
		public static final String TERMINAL                           = "CONVENIO1";
		public static final String N_A                                = "N/A";
		public static final String FECHA_HORA                         = "yyyy-MM-dd HH:mm:ss";
		public static final String PLECA                              = "|";
		public static final String APP_JSON                           = "application/json";
		public static final String EXC                                = "Exc:";
		public static final String ERROR                              = "@@Error";
		public static final String RIF                                = "J000000000";
		public static final String CEDULA                             = "V00000000";
		public static final String TELEFONO                           = "00000000000000";
		public static final String SPLITPLECA                         = "[|]";
	}
	
	
	
	public class Servicios{
		
		private Servicios() {
			super();
		}
		
		
		//MONTO MIN COMISION
		public static final String MONTOMINCOMISIONURLV1       = "/V1";
		public static final String MONTOMINCOMISIONURL       = "/nexopersona/comision";
		public static final String MONTOMINCOMISIONCONSULTAURL       = "/consulta";
		public static final String MONTOMINCOMISIONCONSULTAHISTORIALNURL       = "/consultahistorial";
		
		public static final String MONTOMINCOMISIONCONSULTACONTROLLERI = "[==== INICIO Nexo MontoMinComision-Consulta - Controller ====]";
		public static final String MONTOMINCOMISIONCONSULTACONTROLLERF = "[==== FIN Nexo MontoMinComision-Consulta - Controller ====]";
		
		public static final String MONTOMINCOMISIONACTUALIZARCONTROLLERI = "[==== INICIO Nexo MontoMinComision-Actualizar - Controller ====]";
		public static final String MONTOMINCOMISIONACTUALIZARCONTROLLERF = "[==== FIN Nexo MontoMinComision-Actualizar - Controller ====]";
		
		public static final String MONTOMINCOMISIONHISTORIALCONTROLLERI = "[==== INICIO Nexo MontoMinComision.Historial - Controller ====]";
		public static final String MONTOMINCOMISIONHISTORIALCONTROLLERF = "[==== FIN Nexo MontoMinComision-Historal - Controller ====]";
		
		public static final String MONTOMINCOMISIONCONSULTASERVICEI = "[==== INICIO Nexo MontoMinComision - Service - Consulta ====]";
		public static final String MONTOMINCOMISIONCONSULTASERVICEF = "[==== FIN Nexo MontoMinComision - Service - Consulta ====]";
		
		public static final String MONTOMINCOMISIONACTUALIZARSERVICEI = "[==== INICIO Nexo MontoMinComision - Service - Actualizar ====]";
		public static final String MONTOMINCOMISIONACTUALIZARSERVICEF = "[==== FIN Nexo MontoMinComision - Service - Actualizar ====]";
		
		public static final String HISTORIALMONTOMINCOMISIONSERVICEI = "[==== INICIO Nexo HistorialMontoMinComision - Service - Consulta ====]";
		public static final String HISTORIALMONTOMINCOMISIONSERVICEF = "[==== FIN Nexo HistorialMontoMinComision - Service - Consulta ====]";
		
		public static final String MONTOMINCOMISIONACTUALIZAR  = "Nexo-MontoMinComision Actualizacion";
		
	
		//Auditoria
		
		public static final String ASERVICEI    = "====== INICIO Registrar Auditoria ======";
		public static final String ASERVICEF    = "====== FIN Registrar Auditoria ======";
		
	}
	
	
	public class ExceptionMessages{
		
		private ExceptionMessages() {
			super();
		}
		
		public static final String UNIRESTHTTPE         = "HttpStatusCodeException: %1$s";
		public static final String UNIRESTBODYE         = "ResponseBody: %1$s";
		public static final String UNIRESTE             = "Exception UNI: %1$s";
		
		public static final String AUPRINTERROR         = "ERROR:{}";
		public static final String AUPRINTERRORMENSA    = "Ocurrio un error en registrar Auditoria:{}";
	}
		
	
	
	public class InfoMessages {
		
		private InfoMessages() {
			super();
		}
		
		// Auditoria Service
    	public static final String AUREQUEST                = "Request = [{}]";
    	public static final String AUPRINTINFO              = "registrar Auditoria respuesta: ";
	}
	
	
	
		
	
	
}
