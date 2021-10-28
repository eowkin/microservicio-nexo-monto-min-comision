package com.bancoexterior.nexo.montomincomision;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@PropertySource( value = "file:"+"${${microservicio.ambiente}"+".seed.ruta}", ignoreResourceNotFound = false)
@SpringBootApplication
public class MicroservicioNexoMontoMinComisionApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicioNexoMontoMinComisionApplication.class, args);
	}

	

}
