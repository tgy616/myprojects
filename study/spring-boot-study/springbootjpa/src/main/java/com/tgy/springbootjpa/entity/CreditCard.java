package com.tgy.springbootjpa.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author tanggy
 * @date 2018/5/29
 */
@Entity
@Table(name = "credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 128)
    private String number;
    @Column(name = "reg_date")
    private Date registeredDate;

    @OneToOne(mappedBy = "creditCard")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
