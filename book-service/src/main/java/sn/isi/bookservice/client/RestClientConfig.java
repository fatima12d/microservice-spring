package sn.isi.bookservice.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public  RestClient restClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8080")  // URL du member-service
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
