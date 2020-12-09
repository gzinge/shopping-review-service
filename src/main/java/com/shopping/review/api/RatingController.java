package com.shopping.review.api;

import com.shopping.review.model.Rating;
import com.shopping.review.model.RatingWrapper;
import com.shopping.review.service.RatingBSI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rating")
public class RatingController {

    Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    private RatingBSI ratingBS;

    @PostMapping("/create")
    public ResponseEntity<Object> createRating(@RequestBody Rating rating) throws Exception {
        try {
            int i = ratingBS.createRating(rating);
        }catch (Exception ex) {
            logger.error("Exception occurred while creating Rating", ex);
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>("Rating Created Successfully", HttpStatus.OK);
    }

    @GetMapping("/ratingId/{ratingId}")
    public ResponseEntity<Object> getRatingById(@PathVariable("ratingId") Long ratingId) throws Exception {
        Rating rating = null;
        try {
             rating = ratingBS.getRatingById(ratingId);
        }catch (Exception ex) {
            logger.error("Exception occurred while getting Rating by id: "+ratingId, ex);
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(rating, HttpStatus.OK);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<Object> getRatingsByUserId(@PathVariable("userId") Long userId) throws Exception {
        RatingWrapper ratingWrapper = new RatingWrapper();
        try {
            ratingWrapper.setRatingList(ratingBS.getRatingsByUserId(userId));
        }catch (Exception ex) {
            logger.error("Exception occurred while getting Rating by userId: "+userId, ex);
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(ratingWrapper, HttpStatus.OK);
    }

    @GetMapping("/itemId/{itemId}")
    public ResponseEntity<Object> getRatingByItemId(@PathVariable("itemId") Long itemId) throws Exception {
        RatingWrapper ratingWrapper = new RatingWrapper();
        try {
            ratingWrapper.setRatingList(ratingBS.getRatingByItemId(itemId));
        }catch (Exception ex) {
            logger.error("Exception occurred while getting Rating by itemId: "+itemId, ex);
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(ratingWrapper, HttpStatus.OK);
    }

    @GetMapping("/rateCount/{rateCount}")
    public ResponseEntity<Object> getRatingByRateCount(@PathVariable("rateCount") Integer rateCount) throws Exception {
        RatingWrapper ratingWrapper = new RatingWrapper();
        try {
            ratingWrapper.setRatingList(ratingBS.getRatingByRateCount(rateCount));
        }catch (Exception ex) {
            logger.error("Exception occurred while getting Rating by rateCount: "+rateCount, ex);
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Object>(ratingWrapper, HttpStatus.OK);
    }
}
