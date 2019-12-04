/**
 * 
 */
package com.ishani.isanjaalwebservice.dto;

/**
 * @author Pujan K.C. <pujanov69@gmail.com>
 *
 * Created on Dec 3, 2019
 */
public class VerificationTokenDTO {

	private int id;
    private int userId;
    private String validationKey;
    // private Date expiryDate;
    // private final int EXPIRATION = 60 * 24;

    public VerificationTokenDTO() {}
    
    public VerificationTokenDTO(final String validationKey) {
        this.validationKey = validationKey;
        //this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public VerificationTokenDTO(final String validationKey, int userId){
        this.validationKey = validationKey;
        this.userId = userId;
        //this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getValidationKey() {
        return this.validationKey;
    }

    public void setValidationKey(String validationKey) {
        this.validationKey = validationKey;
    }
}
