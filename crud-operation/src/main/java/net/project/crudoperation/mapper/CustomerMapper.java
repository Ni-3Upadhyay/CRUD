package net.project.crudoperation.mapper;

import net.project.crudoperation.dto.CustomerDto;
import net.project.crudoperation.entity.Customer;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){
        return  new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPassword()
                );
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getPassword()
        );
    }
}
