package org.example.model;

import org.example.model.data.PgUser;

import java.util.List;

public interface PgService {

    List<PgUser> get();

    void save(final PgUser pgUser);

}
