package atu.ie.lab8.controller;

import atu.ie.lab8.model.Passenger;
import atu.ie.lab8.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Passenger> create(@Valid @RequestBody Passenger passenger) {
        Passenger saved = service.create(passenger);
        return ResponseEntity
                .created(URI.create("/api/passengers/" + saved.getId()))
                .body(saved);
    }

    @GetMapping("/{id}")
    public Passenger getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/persons/{employeeId}")
    public Passenger getByEmployeeId(@PathVariable String employeeId) {
        return service.getByEmployeeId(employeeId);
    }

    @PutMapping("/{id}")
    public Passenger update(@PathVariable Long id,
                            @Valid @RequestBody Passenger passenger) {
        return service.update(id, passenger);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

