package net.project.crudoperation.service;

import net.project.crudoperation.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(Long id);

    List<CustomerDto> getAllCustomer();

    CustomerDto updateCustomer(Long id, CustomerDto customerDto);

    CustomerDto deleteCustomer(Long id);

}
