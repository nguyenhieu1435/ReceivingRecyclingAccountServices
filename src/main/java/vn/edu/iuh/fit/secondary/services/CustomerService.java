package vn.edu.iuh.fit.secondary.services;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.secondary.models.Customer;
import vn.edu.iuh.fit.secondary.repositories.CustomerRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public void signUp(Customer customer){
        String hashed = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt());
        customer.setPassword(hashed);
        customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerByEmail(String email){
        return customerRepository.getCustomerByEmail(email);
    }

    public Optional<Customer> getCustomerByPhoneNumber(String phoneNumber){
        return customerRepository.getCustomerByPhoneNumber(phoneNumber);
    }

    public Optional<Customer> signIn(String email, String password){
        Optional<Customer> customer = customerRepository.getCustomerByEmail(email);
        if(customer.isPresent()){

            if(BCrypt.checkpw(password, customer.get().getPassword())){
                return customer;
            }
        }
        return Optional.empty();
    }
}
