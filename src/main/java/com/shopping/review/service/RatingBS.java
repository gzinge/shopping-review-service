package com.shopping.review.service;

import com.shopping.review.feignclient.ItemFeignClient;
import com.shopping.review.feignclient.UserFeignClient;
import com.shopping.review.model.Item;
import com.shopping.review.model.Rating;
import com.shopping.review.model.User;
import com.shopping.review.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingBS implements RatingBSI{

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ItemFeignClient itemFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public int createRating(Rating rating) throws Exception {
       if(rating != null) {
           Rating newRating = new Rating();

           if(rating.getUser() == null || rating.getUser().getId() == null) {
               throw new Exception("Rating must have user.");
           }

           if(rating.getItem() == null || rating.getItem().getId() == null) {
               throw new Exception("Rating must have item.");
           }

           Item item = getItemByIdFromItemService(rating.getItem().getId());
           User user = getUserByIdFromUserService(rating.getUser().getId());

            newRating.setUser(user);
            newRating.setItem(item);
            newRating.setRateCount(rating.getRateCount());
            newRating.setComment(rating.getComment());

            ratingRepository.save(newRating);
            return 1;
       }
       return 0;
    }

    public Item getItemByIdFromItemService(Long itemId) {
        return itemFeignClient.getItemByIdFromItemService(itemId);
    }

    public User getUserByIdFromUserService(Long userId) {
        return userFeignClient.getUserByIdFromUserService(userId);
    }


    @Override
    public Rating getRatingById(Long ratingId) throws Exception {
        if(ratingId != null) {
            Optional<Rating> opt = ratingRepository.findById(ratingId);
            if(opt.isPresent()){
                return opt.get();
            }
        }
        return null;
    }

    @Override
    public List<Rating> getRatingsByUserId(Long userId) throws Exception {
        List<Rating> userRatings = null;
        if(userId != null) {
            userRatings = ratingRepository.findAll().stream().filter(rating -> userId.equals(rating.getUser().getId())).collect(Collectors.toList());
            if(userRatings != null && userRatings.size() > 0){
                return  userRatings;
            }
        }
        return null;
    }

    @Override
    public List<Rating> getRatingByItemId(Long itemId) throws Exception {
        List<Rating> itemRatings = null;
        if(itemId != null) {
            itemRatings = ratingRepository.findAll().stream().filter(rating -> itemId.equals(rating.getItem().getId())).collect(Collectors.toList());
            if(itemRatings != null && itemRatings.size() > 0){
                return  itemRatings;
            }
        }
        return null;
    }

    @Override
    public List<Rating> getRatingByRateCount(Integer rateCount) throws Exception {
        List<Rating> rateCountRatings = null;
        if(rateCount != null) {
            rateCountRatings = ratingRepository.findAll().stream().filter(rating -> rateCount.equals(rating.getRateCount())).collect(Collectors.toList());
            if(rateCountRatings != null && rateCountRatings.size() > 0){
                return rateCountRatings;
            }
        }
        return null;
    }
}
