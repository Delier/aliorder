package com.delier.shop.service;

import com.delier.base.pojo.Order;
import com.delier.base.util.Phase;

public interface ShopService {

    Boolean create(Order order);

    Order getOrder(Long id);

    Boolean cancelOrder(Long id);

    Order updateOrder(Long oId,Phase phase);

    Boolean deleteOrder(Long oId);

}
