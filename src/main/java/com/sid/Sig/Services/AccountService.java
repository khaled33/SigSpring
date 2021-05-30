package com.sid.Sig.Services;


import com.sid.Sig.Entity.AppUser;
import com.sid.Sig.Entity.Role;

import java.util.List;

public interface AccountService {
    public AppUser saveUser(AppUser users);
    public AppUser UpdateUser(AppUser users);
    public AppUser UpdatePssword(AppUser users, Long idUser);
    public Role saveRole(Role role);
    public void addRoleToUser(String email, String rolename);
    public AppUser findUserByEmail(String username);
    public AppUser getCorrentUser( );
    public List<AppUser> getAllUser();


}
