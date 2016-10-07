//package uk.gov.rifs.application.config;
//
// import com.mchange.v2.c3p0.ComboPooledDataSource;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource createDataSource() throws Exception {
//
//        ComboPooledDataSource ds = new ComboPooledDataSource();
//        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/rifs?&user=rifs&password=rifs");
//        ds.setDriverClass("org.postgresql.Driver");
//
//        return ds;
//    }
//
//}