package com.ishani.isanjaalwebservice.serviceImpl;

//import com.ishanitech.ipasal.ipasalwebservice.database.DbHandle;
import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishani.isanjaalwebservice.services.DbService;

@Service
public class DbServiceImpl implements DbService {
    private final DBI dbi;

    @Autowired
    public DbServiceImpl(DBI dbi) {
        this.dbi = dbi;
    }

    @Override
    public <T> T getDao(Class<T> daoClass) {
        if(null != dbi){
            try {
                if (null != daoClass) {
                    return dbi.onDemand(daoClass);
                } else {
                    throw new InternalError("Dao can't be returned!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        throw new InternalError("Dao can't be returned!");
    }

    @Override
    public DBI getDB(String userId) {
        if (null != dbi) {
            return dbi;
        }
        throw new InternalError("DBI can't be returned!");
    }

}
