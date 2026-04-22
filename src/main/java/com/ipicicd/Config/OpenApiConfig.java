package com.ipicicd.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ipiOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("IpiCICD Mini Social API")
                        .description("API pour creer des utilisateurs et leurs posts")
                        .version("1.0"));
    }
}

