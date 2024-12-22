package org.example.perevozki.repositories;

import org.example.perevozki.models.metals;

public class MetalsDao extends BaseDao<metals>{
    public MetalsDao() {
        super(metals.class);
    }
}
