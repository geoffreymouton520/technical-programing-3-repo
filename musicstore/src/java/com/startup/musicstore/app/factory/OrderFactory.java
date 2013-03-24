/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.factory;

import com.startup.musicstore.domain.Order;
import com.startup.musicstore.domain.OrderItem;
import java.util.Date;
import java.util.List;

/**
 *
 * @author geoffrey
 */
public class OrderFactory {
    public static Order getOrder(List<OrderItem> items, int orderNumber, Date date){
         Order order = new Order();
         order.setOrderDate(date);
         order.setOrderItems(items);
         order.setOrderNumber(orderNumber);
         return order;
     }
}
