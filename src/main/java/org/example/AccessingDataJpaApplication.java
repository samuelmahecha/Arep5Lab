package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(PropertyRepository repository) {
        return (args) -> {
            // save a few properties
            repository.save(new Property("123 Main St", 300000, 1500, "Beautiful home in the city"));
            repository.save(new Property("456 Elm St", 400000, 2000, "Spacious house with a garden"));
            // etc...

            // fetch all properties
            log.info("Properties found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(property -> {
                log.info(property.toString());
            });
            log.info("");

            // fetch an individual property by ID
            Property property = repository.findById(1L).orElse(null);
            log.info("Property found with findById(1L):");
            log.info("--------------------------------");
            log.info(property != null ? property.toString() : "Not found");
            log.info("");

            // fetch properties by address
            log.info("Property found with findByAddress('123 Main St'):");
            log.info("--------------------------------------------");
            repository.findByAddress("123 Main St").forEach(p -> {
                log.info(p.toString());
            });
            log.info("");
        };
    }
}
