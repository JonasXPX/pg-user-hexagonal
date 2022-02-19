package org.example.adapter.repository;

import org.example.model.data.PgUser;
import org.example.model.repository.PgPersistencePort;
import org.example.adapter.repository.entity.PgUserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PgUserJpaAdapter implements PgPersistencePort {

    private final SpringDataPgUserRepository repository;

    public PgUserJpaAdapter(SpringDataPgUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(final PgUser pgUser) {
        repository.save(new PgUserEntity(pgUser.getId(), pgUser.getName()));
    }

    @Override
    public List<PgUser> findAll() {
        return repository.findAll()
                .stream()
                .map(pgUserEntity -> new PgUser(pgUserEntity.getId(), pgUserEntity.getName()))
                .collect(Collectors.toList());
    }
}
