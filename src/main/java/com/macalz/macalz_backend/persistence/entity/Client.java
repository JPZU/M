package com.macalz.macalz_backend.persistence.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "client_id", length = 10)
    private String clientId;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 10, nullable = false)
    private String phone;
    @Column(length = 100, nullable = false, unique = true)
    private String email;
//    Relation
//    Relation with purchase 1:N
    @OneToMany(mappedBy = "clientId")
    private List<Purchase> purchases;


    public Client() {}

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
