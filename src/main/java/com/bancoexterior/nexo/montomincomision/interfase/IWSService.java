package com.bancoexterior.nexo.montomincomision.interfase;

import com.bancoexterior.nexo.montomincomision.model.WSRequest;
import com.bancoexterior.nexo.montomincomision.model.WSResponse;

public interface  IWSService {
	WSResponse post(WSRequest request) ;
}
