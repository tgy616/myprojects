package com.tgy.springbootjpa.controller;


import com.tgy.springbootjpa.entity.Customer;
import com.tgy.springbootjpa.repository.CustomerRepository;
import com.tgy.springbootjpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户控制器
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see
 * @since 2017.07.23
 */
@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("all")
    public List<Customer> loadCustomers() {
        return customerRepository.findAll();
    }

    @RequestMapping("get/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerRepository.findOne(id);
    }

    /**
     * @param customer
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {

        customerService.addCustomer(customer);

        Long id = customer.getId();

        return customerService.getCustomerById(id);

    }


}
