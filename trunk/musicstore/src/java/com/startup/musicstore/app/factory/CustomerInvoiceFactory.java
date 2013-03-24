/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.musicstore.app.factory;

import com.startup.musicstore.domain.CustomerInvoice;
import com.startup.musicstore.domain.Order;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author geoffrey
 */
public class CustomerInvoiceFactory {
    public static CustomerInvoice getCustomerInvoice(Date invoiceDate, BigDecimal orderAmount,String invoiceStatus,Order order){
         CustomerInvoice customerInvoice = new CustomerInvoice();
         customerInvoice.setInvoiceDate(invoiceDate);
         customerInvoice.setOrderAmount(orderAmount);
         customerInvoice.setInvoiceStatus(invoiceStatus);
         customerInvoice.setOrder(order);
         return customerInvoice;
     }
}
