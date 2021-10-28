package com.bancoexterior.nexo.montomincomision.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bancoexterior.nexo.montomincomision.seguridad.MiCipher;

import org.apache.commons.dbcp2.BasicDataSource;

@Configuration
public class DBConfig {
 
	@Value("${microservicio.ambiente}")
	private String ambiente;
	@Value("${${microservicio.ambiente}"+".db.user}")
	private String usuario;
	@Value("${${microservicio.ambiente}"+".db.password}")
	private String clave;
	@Value("${${microservicio.ambiente}"+".db.url}")
	private String url;
	@Value("${db.driver}")
	private String driver;
	@Value("${db.initialSize}")
	private String initialSize;
	@Value("${db.testOnBorrow}")
	private String testOnBorrow;
	@Value("${db.testOnReturn}")
	private String testOnReturn;
	@Value("${db.testWhileIdle}")
	private String testWhileIdle;
	@Value("${db.timeBetweenEvictionRunsMillis}")
	private String timeBetweenEvictionRunsMillis;
	@Value("${db.minIdle}")
	private String minIdle;
	@Value("${db.maxTotal}")
	private String maxTotal;
	@Value("${db.maxIdle}")
	private String maxIdle;
	@Value("${db.maxWaitMillis}")
	private String maxWaitMillis;
	@Value("${db.removeAbandonedOnBorrow}")
	private String removeAbandonedOnBorrow;
	@Value("${db.removeAbandonedTimeout}")
	private String removeAbandonedTimeout;
	@Value("${db.logAbandoned}")
	private String logAbandoned;
	@Value("${db.minEvictableIdleTimeMillis}")
	private String minEvictableIdleTimeMillis;
	@Value("${db.defaultAutoCommit}")
	private String defaultAutoCommit;
	@Value("${db.removeAbandonedOnMaintenance}")
	private String removeAbandonedOnMaintenance;
	@Value("${db.validationQuery}")
	private String validationQuery;
	@Value("${db.validationQueryTimeout}")
	private String validationQueryTimeout;
	@Value("${${microservicio.ambiente}"+".seed.montomincomision}")
    private String seed;
	
	
	private BasicDataSource db = new BasicDataSource();
	
	/**
     * Nombre:                  getDataSource
     * Descripcion:             Metodo conexion con la BD
     *
     * @return DataSource 
     * @version 1.0
     * @author Eugenio Owkin
	 * @since 21/10/21
     */
	
	@Bean(name = "dataSource")
	@Primary
    public DataSource getDataSource() {
    	
		
		 db.setUsername(MiCipher.decrypt(usuario.trim(), seed.trim()));
		 db.setPassword(MiCipher.decrypt(clave.trim(), seed.trim()));
		 db.setUrl(url);
		 db.setDriverClassName(driver);
		 db.setInitialSize(Integer.parseInt(initialSize));
		 db.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
		 db.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
		 db.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));
		 db.setTimeBetweenEvictionRunsMillis(Long.parseLong(timeBetweenEvictionRunsMillis));
		 db.setMinIdle(Integer.parseInt(minIdle));
	     db.setMaxTotal(Integer.parseInt(maxTotal));
	     db.setMaxIdle(Integer.parseInt(maxIdle));
		 db.setMaxWaitMillis(Long.parseLong(maxWaitMillis));
		 db.setRemoveAbandonedOnBorrow(Boolean.parseBoolean(removeAbandonedOnBorrow));
		 db.setRemoveAbandonedTimeout(Integer.parseInt(removeAbandonedTimeout));
		 db.setLogAbandoned(Boolean.parseBoolean(logAbandoned));
		 db.setMinEvictableIdleTimeMillis(Long.parseLong(minEvictableIdleTimeMillis));
		 db.setDefaultAutoCommit(Boolean.parseBoolean(defaultAutoCommit));
		 db.setRemoveAbandonedOnMaintenance(Boolean.parseBoolean(removeAbandonedOnMaintenance));
		 db.setValidationQuery(validationQuery);
		 db.setValidationQueryTimeout(Integer.parseInt(validationQueryTimeout));

		 return db;
    	
    }
}
