package co.edu.udistrital.sga.preinscripcion.auto.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class PreinscripcionAutoConfig {

	 
	@Bean(name = "mysqlDb")
	@ConfigurationProperties(prefix = "spring.ds_mysql")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("mysqlDb") DataSource dsMySQL) {
		return new JdbcTemplate(dsMySQL);
	}
	
	@Bean(name = "oracleDb")
	@Primary
	@ConfigurationProperties(prefix = "spring.ds_oracle")
	public DataSource postgresDataSource() {
		return  DataSourceBuilder.create().build();
	}

	@Bean(name = "oracleJdbcTemplate")
	public JdbcTemplate postgresJdbcTemplate(@Qualifier("oracleDb") 
                                              DataSource dsPostgres) {
		return new JdbcTemplate(dsPostgres);
	}
	
	
}
