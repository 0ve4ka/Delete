package org.example.perevozki.services;

import org.example.perevozki.models.gemstones;
import org.example.perevozki.models.metals;
import org.example.perevozki.repositories.GemstonesDao;
import org.example.perevozki.repositories.MetalsDao;

import java.util.List;

public class MetalServices {

private MetalsDao currentDao = new MetalsDao();

public List<metals> findAll(){return currentDao.findAll();}

    public metals findOne(final long id){return currentDao.findOne(id);}

    public void save(final metals entity){
    if (entity == null){
        return;
    }
        currentDao.save(entity);
    }

    public void update(final metals entity){
    if(entity == null){
        return;
    }
        currentDao.update(entity);
    }

    public void delete(final metals entity){
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
