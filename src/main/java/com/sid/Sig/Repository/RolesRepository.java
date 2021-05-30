package com.sid.Sig.Repository;


import com.sid.Sig.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {
    public Role findByRoleName(String roleName);
}
