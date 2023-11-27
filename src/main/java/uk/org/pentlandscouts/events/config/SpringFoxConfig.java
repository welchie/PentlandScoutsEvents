package uk.org.pentlandscouts.events.config;




import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;


@Configuration
public class SpringFoxConfig {
    @Bean
    @Description("Test")
    public OpenAPI pentlandScoutsEventsAPI() {
        return new OpenAPI()
                .info(new Info().title("Pentland Scouts Events API")
                        .description("Back-end APIs for Pentland Scouts Events")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Pentland Scouts")
                        .url("https://sesscouts.org.uk/pentland/"));
    }
}
