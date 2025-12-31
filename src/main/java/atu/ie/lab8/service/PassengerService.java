package atu.ie.lab8.service;

import atu.ie.lab8.exception.PassengerNotFoundException;
import atu.ie.lab8.model.Passenger;
import atu.ie.lab8.repository.PassengerRepository;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    private final PassengerRepository repository;

    public PassengerService(PassengerRepository repository) {
        this.repository = repository;
    }

    public Passenger create(Passenger passenger) {
        return repository.save(passenger);
    }

    public Passenger getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger not found"));
    }

    public Passenger getByEmployeeId(String employeeId) {
        return repository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger not found"));
    }

    public Passenger update(Long id, Passenger updated) {
        Passenger existing = getById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }
}

