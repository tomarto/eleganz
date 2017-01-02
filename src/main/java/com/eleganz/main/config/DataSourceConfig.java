package com.eleganz.main.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 * DataSourceConfig class.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.eleganz.main.repository"})
@EnableTransactionManagement
public class DataSourceConfig {

	/**
	 * <p>
	 * Build an embedded database and creates a DataSource.
	 * </p>
	 * 
	 * @return a {@link javax.sql.DataSource} object.
	 */
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).addScript("db.sql").build();
	}

	/**
	 * <p>
	 * Sets the package location for domain objects.
	 * </p>
	 * 
	 * @return a {@link javax.persistence.EntityManagerFactory} object.
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.eleganz.main.model.domain");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	/**
	 * <p>
	 * Sets the Transaction Manager.
	 * </p>
	 * 
	 * @return a {@link org.springframework.transaction.PlatformTransactionManager} object.
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());

		return txManager;
	}
}
