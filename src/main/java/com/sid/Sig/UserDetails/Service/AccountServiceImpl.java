package com.sid.Sig.UserDetails.Service;


import com.sid.Sig.UserDetails.Dao.AppUsersRepository;
import com.sid.Sig.UserDetails.Dao.RolesRepository;
import com.sid.Sig.UserDetails.Entity.AppUser;
import com.sid.Sig.UserDetails.Entity.Role;
import com.sid.Sig.config.error.ConflictException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class AccountServiceImpl implements AccountService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AppUsersRepository appUsersRepository;
    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public AppUser saveUser(AppUser users) {
         String hashPw=bCryptPasswordEncoder.encode(users.getPassword());
        users.setEnable(true);
        users.setPassword(hashPw);
        users.setCreated(new Date());
        if(appUsersRepository.findByEmail(users.getEmail())!=null)
           throw new ConflictException("Email  déjà  utilisé");
         return appUsersRepository.save(users);
    }

    @Override
    public AppUser UpdateUser(AppUser users, Long idUser) {
        AppUser appUser=appUsersRepository.getOne(idUser);
        users.setId(idUser);
        users.setRoles(appUser.getRoles());
        users.setPassword(appUser.getPassword());
        users.setModified(new Date());

        return appUsersRepository.save(users);
    }

    @Override
    public AppUser UpdatePssword(AppUser users, Long idUser) {
        AppUser appUser=appUsersRepository.getOne(idUser);

        String hashPw=bCryptPasswordEncoder.encode(users.getPassword());
        appUser.setModified(new Date());

        appUser.setPassword(hashPw);
           return appUsersRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        return rolesRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String rolename) {
        Role role= rolesRepository.findByRoleName(rolename);
        AppUser appUser=appUsersRepository.findByEmail(email);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser findUserByEmail(String email) {
        return appUsersRepository.findByEmail(email);
    }

    @Override
    public List<AppUser> getAllUser() {
        return appUsersRepository.findAll();
    }



}
