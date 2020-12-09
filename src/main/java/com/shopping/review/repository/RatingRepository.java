package com.shopping.review.repository;

import com.shopping.review.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {
}
