package com.bancoexterior.nexo.montomincomision.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bancoexterior.nexo.montomincomision.entities.MontoMinComision;


@Repository
public interface IMontoMinComisionRepository extends JpaRepository<MontoMinComision, Integer>{

	public static final String SELECTNEXOMONTOMINCOMISION="SELECT  ID, MONTO,descripción,usuario "
			+ "FROM dbo.MONTO_MIN_COMISION "
			+ "where ID = (case when ?1 = 0 then ID else ?1 end)";
	
	@Query(value = SELECTNEXOMONTOMINCOMISION,
		    nativeQuery = true)
	public List<MontoMinComision> consultaMontoMinComision(int id);
	
	
	public static final String UPDATENEXOMONTOMINCOMISION="UPDATE dbo.MONTO_MIN_COMISION "
			+ "SET MONTO = ?1, descripción = ?2, usuario = ?3 "
			+ "where ID = ?4";
	
	
	@Modifying
	@Transactional
	@Query(value = UPDATENEXOMONTOMINCOMISION,
		    nativeQuery = true)
	public int updateMontoMinComision(BigDecimal monto, String descripcion, String usuario, int id);
	
}
