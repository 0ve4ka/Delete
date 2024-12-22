package org.example.perevozki.repositories;

import org.example.perevozki.models.products;

public class ProductsDao extends BaseDao<products>{
    public ProductsDao() {
        super(products.class);
    }
}
