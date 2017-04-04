package co.edu.udistrital.sga.preinscripcion.auto.configuration;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Accra;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Accurso;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acest;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acestado;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Achorario;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acin;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acinsdemanda;
import co.edu.udistrital.sga.preinscripcion.auto.persistence.entities.oracle.Acinspre;



/**
 * Spring configuration of the "OracleSQL" database.
 * 
 * @author Deivid Suarez.
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "oraclesqlEntityManager", 
		transactionManagerRef = "oraclesqlTransactionManager", 
		basePackages = "co.edu.udistrital.sga.preinscripcion.auto.persistence.repositories.oracle"
)
public class OraclesqlConfiguration {

	/**
	 * PostgreSQL datasource definition.
	 * 
	 * @return datasource.
	 */
	@Bean
	@Primary
	@ConfigurationProperties("spring.oracle.datasource")
	public DataSource oraclesqlDataSource() {
		return DataSourceBuilder
					.create()
					.build();
	}
	
	

	/**
	 * Entity manager definition. 
	 *  
	 * @param builder an EntityManagerFactoryBuilder.
	 * @return LocalContainerEntityManagerFactoryBean.
	 */
	@Primary
	@Bean(name = "oraclesqlEntityManager")
	public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(oraclesqlDataSource())
					.properties(hibernateProperties())
					.packages(Accra.class,Accurso.class,Acest.class,Acestado.class,Achorario.class,Acin.class,Acinsdemanda.class,Acinspre.class)					
					.persistenceUnit("oraclesqlPU")
					.build();
	}

	@Primary
	@Bean(name = "oraclesqlTransactionManager")
	public PlatformTransactionManager OraclesqlTransactionManager(@Qualifier("oraclesqlEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map<String, Object> hibernateProperties() {

		Resource resource = new ClassPathResource("hibernate.properties");
		
		try {
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			return properties.entrySet().stream()
											.collect(Collectors.toMap(
														e -> e.getKey().toString(),
														e -> e.getValue())
													);
		} catch (IOException e) {
			return new HashMap<String, Object>();
		}
	}
}
