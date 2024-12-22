package org.example.perevozki.services;

import org.example.perevozki.models.customers;
import org.example.perevozki.models.deliveryMethods;
import org.example.perevozki.repositories.CustomersDao;
import org.example.perevozki.repositories.DeliveryMethodsDao;

import java.util.List;

public class DeliveryMethodServices {

private DeliveryMethodsDao currentDao = new DeliveryMethodsDao();

public List<deliveryMethods> findAll(){return currentDao.findAll();}

    public deliveryMethods findOne(final long id){return currentDao.findOne(id);}

    public void save(final deliveryMethods entity){
    if (entity == null){
        return;
    }
        currentDao.save(entity);
    }

    public void update(final deliveryMethods entity){
    if(entity == null){
        return;
    }
        currentDao.update(entity);
    }

    public void delete(final deliveryMethods entity){
    if(entity == null){
        return;
    }
        currentDao.delete(entity);
    }

    public void deleteById(final Long id){
    if (id == null){
        return;
    }
        currentDao.deleteById(id);
    }
}
