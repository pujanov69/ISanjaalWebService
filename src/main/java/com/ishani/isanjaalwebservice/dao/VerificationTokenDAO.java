package com.ishani.isanjaalwebservice.dao;


import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import com.ishani.isanjaalwebservice.dto.VerificationTokenDTO;

public interface VerificationTokenDAO {
    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO activation_key(user_id, validation_key) VALUES (:userId, :validationKey)")
    int addVerificationToken(@BindBean VerificationTokenDTO verificationToken);

    @SqlQuery("SELECT * FROM activation_key WHERE validation_key = :validationKey")
    VerificationTokenDTO getVerificationToken(@Bind("validationKey") String validationKey);

    @SqlUpdate("DELETE FROM activation_key WHERE validation_key = :validationKey")
	void deleteToken(@Bind("validationKey") String token);
}