package org.example.controlefinanceiro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.example.controlefinanceiro.repository")
public class JpaConfig {
}

/*rodar front do projeto
1. abrir o projeto no git
2. abrir terminal no vs code
3. rodar 'npm-install' na pasta do projeto para instalar dependencias (só roda na 1 vez)
4. rodar 'ng- serve' na pasta do projeto */