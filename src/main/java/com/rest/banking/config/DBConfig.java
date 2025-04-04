package com.rest.banking.config;

import jakarta.persistence.EntityManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
@EnableJpaRepositories(basePackages = {"com.rest.banking.repository"})
public class DBConfig {

    private static final Logger log = LogManager.getLogger(DBConfig.class);

    @Bean
    public DataSource dataSource() throws SQLException {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        final String url = "jdbc:postgresql://postgres.railway.internal:5432/railway";
        final String username = "postgres";
        final String password = "BFbRSMwDdNDVteFGxlxVjfwfCNCMKdtn";
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            log.info("Database connection succeeded...");

            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

        }catch (SQLException e){
            log.info("Database Connection failed...");
        }

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan("com.rest.banking.model");


        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
