package org.example.perevozki.services;

import org.example.perevozki.models.customers;
import org.example.perevozki.repositories.CustomersDao;

import java.util.List;

public class CustomerServices {

private CustomersDao currentDao = new CustomersDao();

public List<customers> findAll(){return currentDao.findAll();}

    public customers findOne(final long id){return currentDao.findOne(id);}

    public void save(final customers entity){
    if (entity == null){
        return;
    }
        currentDao.save(entity);
    }

    public void update(final customers entity){
    if(entity == null){
        return;
    }
        currentDao.update(entity);
    }

    public void delete(final customers entity){
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
