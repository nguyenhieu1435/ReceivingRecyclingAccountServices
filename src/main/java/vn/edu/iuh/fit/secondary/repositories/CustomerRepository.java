package vn.edu.iuh.fit.secondary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.secondary.models.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    public Optional<Customer> getCustomerByEmail(String email);

    public Optional<Customer> getCustomerByPhoneNumber(String phoneNumber);

    
}