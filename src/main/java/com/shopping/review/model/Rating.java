package com.shopping.review.model;

import javax.persistence.*;

@Entity
@Table(name = "RATING")
public class Rating {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="common_seq")
    @SequenceGenerator(name="common_seq", sequenceName="common_sequence", allocationSize=20)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    private String comment;
    private Integer rateCount;

    public Rating() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRateCount() {
        return rateCount;
    }

    public void setRateCount(Integer rateCount) {
        this.rateCount = rateCount;
    }
}
