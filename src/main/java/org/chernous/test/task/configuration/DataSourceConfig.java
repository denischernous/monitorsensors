package org.chernous.test.task.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String mainDbUrl;

    @Value("${spring.datasource.username}")
    private String mainDbUsername;

    @Value("${spring.datasource.password}")
    private String mainDbPassword;

    @Value("${spring.statistics.datasource.url}")
    private String statsDbUrl;

    @Value("${spring.statistics.datasource.username}")
    private String statsDbUsername;

    @Value("${spring.statistics.datasource.password}")
    private String statsDbPassword;

    // Основной datasource для датчиков
    @Bean(name = "mainDataSource")
    public DataSource mainDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(mainDbUrl);
        dataSource.setUsername(mainDbUsername);
        dataSource.setPassword(mainDbPassword);
        return dataSource;
    }

    // DataSource для статистики
    @Bean(name = "statisticsDataSource")
    public DataSource statisticsDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(statsDbUrl);
        dataSource.setUsername(statsDbUsername);
        dataSource.setPassword(statsDbPassword);
        return dataSource;
    }

    // SpringLiquibase для основной БД
    @Bean(name = "mainLiquibase")
    public SpringLiquibase mainLiquibase(@Qualifier("mainDataSource") DataSource mainDataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(mainDataSource);
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.yaml");
        return liquibase;
    }


    // SpringLiquibase для БД статистики
    @Bean(name = "statisticsLiquibase")
    public SpringLiquibase statisticsLiquibase(@Qualifier("statisticsDataSource") DataSource statisticsDataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(statisticsDataSource);
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-statistics.yaml");
        return liquibase;
    }
}
