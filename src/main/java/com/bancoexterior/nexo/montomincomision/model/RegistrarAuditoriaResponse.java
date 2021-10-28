package com.bancoexterior.nexo.montomincomision.model;

import com.bancoexterior.nexo.montomincomision.response.Resultado;

public class RegistrarAuditoriaResponse {
	
	private Resultado resultado;


	public RegistrarAuditoriaResponse() {
		super();
		this.resultado = new Resultado();
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	@Override
    public String toString() {
          return "RegistrarAuditoriaResponse [resultado=" + resultado +"]";

    }
}
