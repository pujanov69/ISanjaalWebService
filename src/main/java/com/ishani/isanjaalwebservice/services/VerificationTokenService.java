package com.ishani.isanjaalwebservice.services;

import com.ishani.isanjaalwebservice.dto.VerificationTokenDTO;

public interface VerificationTokenService{
    public int addVerificationToken(VerificationTokenDTO tokenDTO);
    public VerificationTokenDTO getVerificationToken(String validationToken);
    public String validateVerificationToken(String token);
    public Integer resetPasswordTokenVerification(String token);
}