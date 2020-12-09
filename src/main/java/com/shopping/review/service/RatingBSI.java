package com.shopping.review.service;

import com.shopping.review.model.Rating;

import java.util.List;

public interface RatingBSI {

    public int createRating(Rating rating) throws Exception;

    public Rating getRatingById(Long ratingId) throws Exception;

    public List<Rating> getRatingsByUserId(Long userId) throws Exception;

    public List<Rating> getRatingByItemId(Long itemId) throws Exception;

    public List<Rating> getRatingByRateCount(Integer rateCount) throws Exception;
}
