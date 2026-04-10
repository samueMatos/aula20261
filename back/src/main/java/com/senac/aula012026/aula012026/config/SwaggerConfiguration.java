package com.senac.aula012026.aula012026.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {


    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info( new Info()
                .title("API Aula Full Stack")
                .version("1.0")
                .description("Api responsavel por passar o conhecimento aos academicos!")
                .termsOfService("https://www.mtxsistemas.com")
        );
    }


}
