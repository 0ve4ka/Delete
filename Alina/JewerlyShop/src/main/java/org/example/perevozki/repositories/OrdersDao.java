package org.example.perevozki.repositories;

import org.example.perevozki.models.orders;

public class OrdersDao extends BaseDao<orders>{
    public OrdersDao() {
        super(orders.class);
    }
}
