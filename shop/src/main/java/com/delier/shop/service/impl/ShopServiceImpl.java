package com.delier.shop.service.impl;

import com.delier.base.pojo.Order;
import com.delier.base.pojo.Product;
import com.delier.base.util.Phase;
import com.delier.shop.client.AccountClient;
import com.delier.shop.client.StockClient;
import com.delier.shop.dao.OrderDao;
import com.delier.shop.dao.ProductDao;
import com.delier.shop.service.ShopService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;


    @Autowired
    AccountClient accountClient;

    @Autowired
    StockClient stockClient;

    @Override
    @GlobalTransactional
    public Boolean create(Order order) {
        Product product = order.getProduct();
        //扣减库存
        stockClient.decreaseStock(product);
        //创建订单
        orderDao.save(order);
        //订单进入消息队列，可以超时取消订单
        return Boolean.TRUE;
    }

    @Override
    public Order getOrder(Long id) {
        Optional<Order> orderOpt = orderDao.findById(id);
        return orderOpt.get();
    }

    @Override
    @GlobalTransactional
    public Boolean cancelOrder(Long id) {
        System.out.println("+++++++++++++++++"+RootContext.getXID());
        //查询订单
        Optional<Order> orderOpt = orderDao.findById(id);
        Order order = orderOpt.get();
        order.setPhase(Phase.CANCEL);
        Product product = order.getProduct();
        //取消订单,注意取消订单期间的同时付款
        orderDao.save(order);
        //退还库存
        stockClient.increaseStock(product);
        return Boolean.TRUE;
    }

    @Override
    public Order updateOrder(Long oId,Phase phase) {
        Optional<Order> orderOpt = orderDao.findById(oId);
        Order order = orderOpt.get();
        order.setPhase(phase);
        orderDao.saveAndFlush(order);
        return order;
    }

    @Override
    public Boolean deleteOrder(Long oId) {
        Order order = orderDao.findById(oId).get();
        if (order.getPhase()==Phase.CANCEL)
            orderDao.deleteById(oId);
        else{
            // TODO: 2023/11/2 处理
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
