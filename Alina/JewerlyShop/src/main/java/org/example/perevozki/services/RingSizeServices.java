package org.example.perevozki.services;

import org.example.perevozki.models.products;
import org.example.perevozki.models.ringSizes;
import org.example.perevozki.repositories.ProductsDao;
import org.example.perevozki.repositories.RingSizeDao;

import java.util.List;

public class RingSizeServices {

private RingSizeDao currentDao = new RingSizeDao();

public List<ringSizes> findAll(){return currentDao.findAll();}

    public ringSizes findOne(final long id){return currentDao.findOne(id);}

    public void save(final ringSizes entity){
    if (entity == null){
        return;
    }
        currentDao.save(entity);
    }

    public void update(final ringSizes entity){
    if(entity == null){
        return;
    }
        currentDao.update(entity);
    }

    public void delete(final ringSizes entity){
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
