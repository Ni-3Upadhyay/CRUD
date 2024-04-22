package net.project.crudoperation.service.impl;

import lombok.AllArgsConstructor;
import net.project.crudoperation.dto.CustomerDto;
import net.project.crudoperation.entity.Customer;
import net.project.crudoperation.exception.ResourceNotFoundException;
import net.project.crudoperation.mapper.CustomerMapper;
import net.project.crudoperation.repository.CustomerRepository;
import net.project.crudoperation.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);

        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow( ()-> new ResourceNotFoundException("Employee Does not exist by this id " + id));

        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {

        List<Customer> customers= customerRepository.findAll();

        return customers.stream().map((customer)-> CustomerMapper.mapToCustomerDto(customer))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer does not exist with this id "+ id));

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customer.getPassword());

        Customer updatedCustomer = customerRepository.save(customer);

        return CustomerMapper.mapToCustomerDto(updatedCustomer);

    }

    @Override
    public CustomerDto deleteCustomer(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer does not exist with this id "+ id));


        customerRepository.deleteById(id);

        return CustomerMapper.mapToCustomerDto(customer);
    }

}
