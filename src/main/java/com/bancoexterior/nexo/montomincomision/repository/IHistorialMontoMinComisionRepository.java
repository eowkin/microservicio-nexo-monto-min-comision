package com.bancoexterior.nexo.montomincomision.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bancoexterior.nexo.montomincomision.entities.HistorialMontoMinComision;


@Repository
public interface IHistorialMontoMinComisionRepository extends JpaRepository<HistorialMontoMinComision, Integer>{

	public static final String SELECTNEXOHISTORIALMONTOMINCOMISION="SELECT  ID, USUARIO, DESCRIPCION, MONTO, FECHA "
			+ "FROM dbo.HISTORIAL_MONTO_MIN_COMISION ";
	
	@Query(value = SELECTNEXOHISTORIALMONTOMINCOMISION,
		    nativeQuery = true)
	public List<HistorialMontoMinComision> consultaHistorialMontoMinComision();
}
