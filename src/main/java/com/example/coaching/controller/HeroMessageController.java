package com.example.coaching.controller;

import com.example.coaching.model.HeroMessage;
import com.example.coaching.repository.HeroMessageRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hero")
public class HeroMessageController {

    private final HeroMessageRepository repo;

    public HeroMessageController(HeroMessageRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<HeroMessage> getAll() {
        return repo.findAllByOrderByDisplayOrderAsc();
    }

    @PostMapping
    public ResponseEntity<HeroMessage> create(@Valid @RequestBody HeroMessage message) {
        HeroMessage saved = repo.save(message);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeroMessage> update(@PathVariable Long id, @RequestBody HeroMessage body) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(body.getTitle());
            existing.setText(body.getText());
            existing.setNote(body.getNote());
            existing.setBackgroundImageUrl(body.getBackgroundImageUrl());
            existing.setDisplayOrder(body.getDisplayOrder());
            repo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
