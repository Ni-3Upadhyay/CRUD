package net.project.crudoperation.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.project.crudoperation.dto.CustomerDto;
import net.project.crudoperation.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customerDto){

        CustomerDto savedCustomer = customerService.createCustomer(customerDto);

        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id){
        CustomerDto customerDto = customerService.getCustomerById(id);

        return ResponseEntity.ok(customerDto);
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){

        List<CustomerDto> customers = customerService.getAllCustomer();

        return ResponseEntity.ok(customers);

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long id,@RequestBody CustomerDto customerDto){

        CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerDto> deleteCustomerById(@PathVariable("id") Long id){

        CustomerDto customer =customerService.deleteCustomer(id);

        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

 }
