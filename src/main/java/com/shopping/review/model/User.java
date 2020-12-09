package com.shopping.review.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

    @Id
    //@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="common_seq")
    private Long id;
    private String name;

    public User() {
    }

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
}
