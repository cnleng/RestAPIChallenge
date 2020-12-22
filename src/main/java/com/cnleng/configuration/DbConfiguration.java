package com.cnleng.configuration;

//@Configuration
//@ConfigurationProperties(prefix = "databaseConfiguration")
public class DbConfiguration {
    private String url;
    private String username;
    private String password;
    private String driver;

    public DbConfiguration() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

//    @Bean
//    public DataSource dataSource() {
//        final BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() throws Exception {
//        return new JdbcTemplate(dataSource());
//    }

//    @Bean
//    public TransactionAttributeSource annotationTransactionAttributeSource() {
//        return new AnnotationTransactionAttributeSource();
//    }
//
//    @Bean
//    public TransactionInterceptor transactionInterceptor() {
//        return new TransactionInterceptor(transactionManager(), annotationTransactionAttributeSource());
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource());
//    }
}
