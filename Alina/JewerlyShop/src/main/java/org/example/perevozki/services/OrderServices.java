package org.example.perevozki.services;

import org.example.perevozki.models.metals;
import org.example.perevozki.models.orders;
import org.example.perevozki.repositories.MetalsDao;
import org.example.perevozki.repositories.OrdersDao;

import java.util.List;

public class OrderServices {

private OrdersDao currentDao = new OrdersDao();

public List<orders> findAll(){return currentDao.findAll();}

    public orders findOne(final long id){return currentDao.findOne(id);}

    public void save(final orders entity){
    if (entity == null){
        return;
    }
        currentDao.save(entity);
    }

    public void update(final orders entity){
    if(entity == null){
        return;
    }
        currentDao.update(entity);
    }

    public void delete(final orders entity){
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
