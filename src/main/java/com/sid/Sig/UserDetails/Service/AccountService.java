package com.sid.Sig.UserDetails.Service;


import com.sid.Sig.UserDetails.Entity.AppUser;
import com.sid.Sig.UserDetails.Entity.Role;

import java.util.List;

public interface AccountService {
    public AppUser saveUser(AppUser users);
    public AppUser UpdateUser(AppUser users, Long idUser);
    public AppUser UpdatePssword(AppUser users, Long idUser);
    public Role saveRole(Role role);
    public void addRoleToUser(String email, String rolename);
    public AppUser findUserByEmail(String username);
    public List<AppUser> getAllUser();


}
