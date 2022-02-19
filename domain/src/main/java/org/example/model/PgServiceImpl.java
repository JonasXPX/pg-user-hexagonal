package org.example.model;

import org.example.model.data.PgUser;
import org.example.model.repository.PgPersistencePort;

import java.util.List;

public class PgServiceImpl implements PgService {

    private final PgPersistencePort persistence;

    public PgServiceImpl(final PgPersistencePort persistence) {
        this.persistence = persistence;
    }

    @Override
    public List<PgUser> get() {
        return persistence.findAll();
    }

    @Override
    public void save(final PgUser pgUser) {
        if (pgUser.getName() != null && pgUser.getName().isBlank()) {
            throw new IllegalArgumentException("name is required");
        }

        persistence.save(pgUser);
    }
}
