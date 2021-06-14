package com.mathpar.plan._configs;


import com.mathpar.plan.utils.MathparProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class PropertiesConfiguration {
    @Bean
    @Profile("!test")
    public MathparProperties mathparProperties(@Value("${mathpar.secretmanagerUrlPrefix}") String prefix){
        var properties = new MathparProperties();
        properties.loadPropertiesFromManager(prefix);
        return properties;
    }
}
