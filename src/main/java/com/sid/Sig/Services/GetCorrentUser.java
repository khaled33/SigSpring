package com.sid.Sig.Services;

import com.sid.Sig.Repository.AppUsersRepository;
import com.sid.Sig.Entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public abstract class GetCorrentUser {
    @Autowired
    private AppUsersRepository appUsersRepository;

    public AppUser getCorrentUser(){
         Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        return appUsersRepository.findByEmail(authentication.getName());
    }
}
