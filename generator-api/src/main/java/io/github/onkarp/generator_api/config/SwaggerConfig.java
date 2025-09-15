package io.github.onkarp.generator_api.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI trackingApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tracking Number Generator API")
                        .description("REST API that generates unique tracking numbers for parcels.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Onkar P.")
                                .email("omkarpanchakshari7620@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Repository")
                        .url("https://github.com/your-repo/tracking-api"));
    }
}
