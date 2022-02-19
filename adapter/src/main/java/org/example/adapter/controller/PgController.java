package org.example.adapter.controller;

import org.example.model.PgService;
import org.example.model.data.PgUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("pg-user")
public class PgController {

    private final PgService service;

    public PgController(final PgService service) {
        this.service = service;
    }

    @PostMapping
    public void savePgUser(@RequestBody final PgUser pgUser) {
        service.save(pgUser);
    }

    @GetMapping
    public ResponseEntity<List<PgUser>> getAllPgUsers() {
        return ResponseEntity.ok(service.get());
    }
}
