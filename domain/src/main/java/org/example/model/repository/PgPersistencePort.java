package org.example.model.repository;

import org.example.model.data.PgUser;

import java.util.List;

public interface PgPersistencePort {

    void save(final PgUser pgUser);

    List<PgUser> findAll();
}
