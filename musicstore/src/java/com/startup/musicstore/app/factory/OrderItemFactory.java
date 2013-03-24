/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.factory;

import com.startup.musicstore.domain.Album;
import com.startup.musicstore.domain.OrderItem;

/**
 *
 * @author geoffrey
 */
public class OrderItemFactory {
    public static OrderItem getOrderItem(int quantity, Album album){
         
         OrderItem orderItem = new OrderItem();
         orderItem.setQuantity(quantity);
         orderItem.setAlbum(album);
         return orderItem;
     }
}
