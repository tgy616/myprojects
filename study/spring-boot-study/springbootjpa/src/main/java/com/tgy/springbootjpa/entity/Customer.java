package com.tgy.springbootjpa.entity;

import com.tgy.springbootjpa.entity.listener.CustomerListener;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author tanggy
 * @date 2018/5/29
 */
@Entity
@Access(value = AccessType.FIELD)
@Table(name="customers")
@EntityListeners(value = {CustomerListener.class})
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 64)
    private String name;

    @OneToOne
    private CreditCard creditCard;

    @ManyToOne
    private Store store;

    @ManyToMany
    private Collection<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
