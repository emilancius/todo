package org.emgen.todo.controller;

import org.emgen.todo.service.EntryService;
import org.emgen.todo.transmission.Entry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/entries")
public class EntryController {

    private final EntryService service;

    public EntryController(EntryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Entry>> fetch() {
        return new ResponseEntity<>(service.fetchEntries(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> fetch(@PathVariable Long id) {
        Optional<Entry> entry = service.fetchEntry(id);
        return entry.isPresent() ? new ResponseEntity<>(entry.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Entry> save(@RequestBody Entry entry) {
        return new ResponseEntity<>(service.saveEntry(entry), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> remove() {
        service.remove();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
