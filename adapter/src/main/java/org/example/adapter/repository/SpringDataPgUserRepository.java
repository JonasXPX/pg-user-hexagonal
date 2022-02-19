package org.example.adapter.repository;

import org.example.adapter.repository.entity.PgUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataPgUserRepository extends JpaRepository<PgUserEntity, Long> {
}
