package com.example.bookshop.model;

import javax.persistence.*;

@Entity(name = "rent")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "RentDate")
    private String rentD;


    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getRentD() {
        return rentD;
    }

    public void setRentD(String rentD) {
        this.rentD = rentD;
    }
}
