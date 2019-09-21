package br.com.sgr.conf;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class DatabaseConfig {
	
	@Autowired
	private Environment env;

	/*
	 * @Value("${db.driver}") private String DB_DRIVER;
	 * 
	 * @Value("${db.password}") private String DB_PASSWORD;
	 * 
	 * @Value("${db.url}") private String DB_URL;
	 * 
	 * @Value("${db.username}") private String DB_USERNAME;
	 */

	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;

	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;

	@Value("${hibernate.hbm2ddl.auto}")
	private String HIBERNATE_HBM2DDL_AUTO;

	@Value("${entitymanager.packagesToScan}")
	private String ENTITYMANAGER_PACKAGES_TO_SCAN;

	@Bean
	@ConfigurationProperties(prefix = "db")
	public DataSource dataSource() {
		/*
		 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 * dataSource.setDriverClassName(DB_DRIVER); dataSource.setUrl(DB_URL);
		 * dataSource.setUsername(DB_USERNAME); dataSource.setPassword(DB_PASSWORD);
		 * return dataSource;
		 */
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);

		Properties hibernateProperties = hibernateProperties();
		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;
	}

	private Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		return hibernateProperties;
	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		managerFactoryBean.setDataSource(dataSource());
//		managerFactoryBean.setPackagesToScan(new String[] { ENTITYMANAGER_PACKAGES_TO_SCAN });
//		
//		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		managerFactoryBean.setJpaVendorAdapter(vendorAdapter);
//		return managerFactoryBean;
//	}

	@Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

}