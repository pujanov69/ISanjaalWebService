package com.ishani.isanjaalwebservice.services;

//import com.ishanitech.ipasal.ipasalwebservice.database.DbHandle;
import org.skife.jdbi.v2.DBI;

public interface DbService {
    /**
     * returns the DAO class of class
     *
     * @param daoClass Class com.ishanitech.isuchana.dao class
     * @return <T> generic response
     */

    // Currently not in use can be used in future
    //<T> T getDao(String userId, Class<T> daoClass);

    <T> T getDao(Class<T> daoClass);

    /**
     * Returns the DBI object for given client
     *
     * @param userId String userId
     * @return DBI
     */
    DBI getDB(String userId);

}
