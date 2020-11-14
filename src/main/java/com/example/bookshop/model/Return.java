package com.example.bookshop.model;


import javax.persistence.*;

@Entity(name = "return")
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Return_id")
    private Integer id;

    @Column(name = "ReturnDate")
    private String returnD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReturnD() {
        return returnD;
    }

    public void setReturnD(String returnD) {
        this.returnD = returnD;
    }
}
