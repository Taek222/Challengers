package kr.co.challengers.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource") //빌드할때 필요한 정보(properties)를 어디서 찾을지 명시
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
}
