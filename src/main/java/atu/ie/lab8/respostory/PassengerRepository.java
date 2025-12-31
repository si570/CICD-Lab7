package atu.ie.lab8.repository;

import atu.ie.lab8.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Optional<Passenger> findByEmployeeId(String employeeId);
}
