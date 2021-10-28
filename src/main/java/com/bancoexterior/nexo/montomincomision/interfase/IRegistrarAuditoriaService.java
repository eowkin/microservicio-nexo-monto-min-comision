package com.bancoexterior.nexo.montomincomision.interfase;

import com.bancoexterior.nexo.montomincomision.model.RegistrarAuditoriaRequest;

public interface IRegistrarAuditoriaService {
	
	void registrarAuditoria(RegistrarAuditoriaRequest auditoria,  String codigo, String mensaje, String errorAdicional);

}
