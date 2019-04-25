package com.tgy.springbootjpa.service;

import com.tgy.springbootjpa.entity.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * 客户服务
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see
 * @since 2017.07.23
 */
@Service
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 添加客户
     *
     * @param customer
     */
    @Transactional
    public void addCustomer(Customer customer) {

        entityManager.persist(customer);

    }

    public Customer getCustomerById(Long id) {

        return entityManager.find(Customer.class, id);

    }

}
