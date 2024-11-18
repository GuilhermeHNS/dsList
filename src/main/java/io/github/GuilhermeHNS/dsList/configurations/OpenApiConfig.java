package io.github.GuilhermeHNS.dsList.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gerenciamento de Lista de Jogos")
                        .version("1.0")
                        .description("API para gerenciar lista de jogos")
                        .contact(new Contact()
                                .name("Guilherme Henrique")
                                .email("guilhermehenriquenovaes@gmail.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .addTagsItem(new io.swagger.v3.oas.models.tags.Tag().name("Games").description("Operações relacionadas a Games"))
                .addTagsItem(new io.swagger.v3.oas.models.tags.Tag().name("ListGames").description("Operações relacionadas a Lista de Games"))
                .addSecurityItem(new SecurityRequirement());

    }

}
