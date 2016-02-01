package com.tsm.project.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.tsm.project.repository")
public class PersistenceConfig {

	// private static final String DATASOURCE_JNDINAME = "datasource.jndiname";

	private static final String DATASOURCE_DRIVER = "datasource.driver";
	private static final String DATASOURCE_URL = "datasource.url";
	private static final String DATASOURCE_USERNAME = "datasource.username";
	private static final String DATASOURCE_PASSWORD = "datasource.password";
	private static final String DATASOURCE_INITIALSIZE = "datasource.initialSize";
	private static final String DATASOURCE_MAXACTIVE = "datasource.maxActive";
	private static final String DATASOURCE_MAXIDLE = "datasource.maxIdle";

	@Autowired
	private Environment env;

	// @Bean
	// public DataSource dataSourceJndi() {
	// JndiDataSourceLookup jndiDataSource = new JndiDataSourceLookup();
	// return
	// jndiDataSource.getDataSource(env.getProperty(DATASOURCE_JNDINAME));
	// }

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		// final org.apache.commons.dbcp.BasicDataSource dataSource = new
		// org.apache.commons.dbcp.BasicDataSource();
		// dataSource.setDriverClassName(env.getRequiredProperty(DATASOURCE_DRIVER));
		// dataSource.setUrl(env.getRequiredProperty(DATASOURCE_URL));
		// dataSource.setUsername(env.getRequiredProperty(DATASOURCE_USERNAME));
		// dataSource.setPassword(env.getRequiredProperty(DATASOURCE_PASSWORD));
		// dataSource.setInitialSize(env.getRequiredProperty(DATASOURCE_INITIALSIZE,
		// Integer.class));
		// dataSource.setMaxActive(env.getRequiredProperty(DATASOURCE_MAXACTIVE,
		// Integer.class));
		// dataSource.setMaxIdle(env.getRequiredProperty(DATASOURCE_MAXIDLE,
		// Integer.class));
		final com.mchange.v2.c3p0.ComboPooledDataSource dataSource = new com.mchange.v2.c3p0.ComboPooledDataSource();
		try {
			dataSource.setDriverClass("org.postgresql.Driver");
			dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/tsm_finalProject");
			dataSource.setUser("postgres");
			dataSource.setPassword("password");
			dataSource.setInitialPoolSize(10);
			dataSource.setMaxPoolSize(100);
			dataSource.setMinPoolSize(10);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}

	// @Bean
	// public DataSourceInitializer dataSourceInitializer(DataSource dataSource)
	// {
	// DataSourceInitializer dataSourceInitializer = new
	// DataSourceInitializer();
	// dataSourceInitializer.setDataSource(dataSource);
	// ResourceDatabasePopulator databasePopulator = new
	// ResourceDatabasePopulator();
	// databasePopulator.addScript(new ClassPathResource("db.sql"));
	// dataSourceInitializer.setDatabasePopulator(databasePopulator);
	// dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
	// return dataSourceInitializer;
	// }

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.tsm.project.model" });

		Properties props = new Properties();
		props.put(org.hibernate.cfg.Environment.DEFAULT_SCHEMA, "main");
		props.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		props.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
		props.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
		props.put(org.hibernate.cfg.Environment.FORMAT_SQL, "false");
		props.put(org.hibernate.cfg.Environment.USE_REFLECTION_OPTIMIZER, true);
		props.put(org.hibernate.cfg.Environment.CACHE_REGION_FACTORY,
				org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory.class.getName());
		props.put(org.hibernate.cfg.Environment.USE_QUERY_CACHE, true);
		props.put(org.hibernate.cfg.Environment.USE_SECOND_LEVEL_CACHE, true);
		sessionFactory.setHibernateProperties(props);
		sessionFactory.setNamingStrategy(new ImprovedNamingStrategy());

		return sessionFactory;
	}

	// @Bean
	// public HibernateTransactionManager transactionManager() {
	// HibernateTransactionManager txManager = new
	// HibernateTransactionManager();
	// txManager.setSessionFactory(sessionFactory().getObject());
	// return txManager;
	// }

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.tsm.project.model");

		Properties jpaProperties = new Properties();
		// jpaProperties.put("hibernate.hbm2ddl.auto",
		// env.getProperty("hibernate.hbm2ddl.auto"));
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		EntityManagerFactory factory = entityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
