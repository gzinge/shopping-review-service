package com.shopping.review.feignclient;

import com.shopping.review.model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "item-service", url = "http://localhost:58007")
public interface ItemFeignClient {

    @GetMapping("/item/id/{id}")
    public Item getItemByIdFromItemService(@PathVariable("id") Long itemId);

}
