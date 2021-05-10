package com.sid.Sig.UserDetails.Dao;


import com.sid.Sig.UserDetails.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUsersRepository extends JpaRepository<AppUser, Long> {
    public AppUser findByEmail(String email);
}
