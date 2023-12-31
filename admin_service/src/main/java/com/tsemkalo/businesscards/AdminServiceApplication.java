package com.tsemkalo.businesscards;

import com.tsemkalo.businesscards.configuration.RabbitConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Import(RabbitConfiguration.class)
@EnableJpaRepositories
@SpringBootApplication
@EnableTransactionManagement
public class AdminServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminServiceApplication.class, args);
    }
}
