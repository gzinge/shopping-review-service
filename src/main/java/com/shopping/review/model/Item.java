package com.shopping.review.model;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    private Long id;
    private String name;

    public Item() {
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
