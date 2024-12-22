package org.example.perevozki.services;

import org.example.perevozki.models.deliveryMethods;
import org.example.perevozki.models.gemstones;
import org.example.perevozki.repositories.DeliveryMethodsDao;
import org.example.perevozki.repositories.GemstonesDao;

import java.util.List;

public class GemstoneServices {

private GemstonesDao currentDao = new GemstonesDao();

public List<gemstones> findAll(){return currentDao.findAll();}

    public gemstones findOne(final long id){return currentDao.findOne(id);}

    public void save(final gemstones entity){
    if (entity == null){
        return;
    }
        currentDao.save(entity);
    }

    public void update(final gemstones entity){
    if(entity == null){
        return;
    }
        currentDao.update(entity);
    }

    public void delete(final gemstones entity){
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
