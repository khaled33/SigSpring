package com.sid.Sig.UserDetails.Dao;


import com.sid.Sig.UserDetails.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {
    public Role findByRoleName(String roleName);
}
