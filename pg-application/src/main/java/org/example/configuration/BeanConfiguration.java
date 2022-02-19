package org.example.configuration;

import org.example.adapter.repository.PgUserJpaAdapter;
import org.example.adapter.repository.SpringDataPgUserRepository;
import org.example.model.PgService;
import org.example.model.PgServiceImpl;
import org.example.model.repository.PgPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final SpringDataPgUserRepository repository;

    public BeanConfiguration(final SpringDataPgUserRepository repository) {
        this.repository = repository;
    }

    @Bean
    PgPersistencePort pgPersistencePort() {
        return new PgUserJpaAdapter(repository);
    }

    @Bean
    PgService initPgService() {
        return new PgServiceImpl(pgPersistencePort());
    }

}
