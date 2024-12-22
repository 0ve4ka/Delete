package org.example.perevozki.repositories;

import org.example.perevozki.models.customers;

public class CustomersDao extends BaseDao<customers>{

    public CustomersDao() {
        super(customers.class);
    }
}
