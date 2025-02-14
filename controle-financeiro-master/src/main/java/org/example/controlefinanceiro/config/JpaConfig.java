package org.example.controlefinanceiro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.example.controlefinanceiro.repository")
public class JpaConfig {
}