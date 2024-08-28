package com.springapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Comparator;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customers")
public class Customer implements Cloneable, Comparator<Customer> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Size(min = 3, max = 30)
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Size(min = 3, max = 30)
    @Column(name = "full_name", nullable = false)
    private String customerFullName;

    @Size(min = 3, max = 30)
    @Column(name = "email", unique = true, nullable = false)
    private String customerEmail;

    @Size(min = 3, max = 30)
    @Column(name = "password", nullable = false)
    private String customerPassword;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Customer(String username, String customerFullName, String customerEmail, String customerPassword, LocalDateTime createdAt) {
        this.username = username;
        this.customerFullName = customerFullName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.createdAt = createdAt;
    }

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getCustomerId().compareTo(o2.getCustomerId());
    }

    @Override
    public Customer clone() {
        try {
            return (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Customer(this.username, this.customerFullName, this.customerEmail,
                    this.customerPassword, this.createdAt);
        }
    }
}