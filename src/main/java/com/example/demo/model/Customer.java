package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "customer")
@SequenceGenerator(name = "public.customer_id_seq", sequenceName = "public.customer_id_seq", initialValue = 1, allocationSize = 1)
public class Customer implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "public.customer_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "role")
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(email, customer.email) && Objects.equals(pwd, customer.pwd) && Objects.equals(role, customer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, pwd, role);
    }
}
