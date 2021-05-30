package com.sid.Sig.Repository;


import com.sid.Sig.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUsersRepository extends JpaRepository<AppUser, Long> {
    public AppUser findByEmail(String email);
}
