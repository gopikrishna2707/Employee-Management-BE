package com.example.Employee_Be.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI mySwagger(){
        return new OpenAPI()
                .info(new Info()
                        .title("TEMA Api")
                        .version("TEMA V1")
                        .description("Employee Service")
                );
    }

}
