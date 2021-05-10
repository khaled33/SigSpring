package com.sid.Sig.UserDetails.Controller;


import com.sid.Sig.UserDetails.Entity.AppUser;
import com.sid.Sig.UserDetails.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountUserController {
    @Autowired
    private AccountService accountService;
    @ExceptionHandler(DataIntegrityViolationException.class)
    @PostMapping("/Register")
    public ResponseEntity<AppUser> Register(@Validated @RequestBody AppUser appUser) {

//        List<Role> roleDefault= Collections.singletonList(new Role("Anonyme", null));
//        appUser.setRoles(roleDefault);
                 return new ResponseEntity<>(accountService.saveUser(appUser), HttpStatus.CREATED);


    }
 @PutMapping("/UpdateUser/{idUser}")
    public ResponseEntity<AppUser> UpdateUser(@RequestBody AppUser appUser, @PathVariable Long idUser) {

                  return new ResponseEntity<>(accountService.UpdateUser(appUser,idUser), HttpStatus.CREATED);

    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<AppUser> Login(@PathVariable String email) {

        return new ResponseEntity<>(accountService.findUserByEmail(email), HttpStatus.OK);

    }
    @PutMapping("/UpdatePassword/{idUser}")
    public ResponseEntity<AppUser> UpdatePssword(@RequestBody AppUser users, @PathVariable Long idUser) {
        return new ResponseEntity<>(accountService.UpdatePssword(users,idUser), HttpStatus.CREATED);
    }
    @GetMapping("/Users")
    public ResponseEntity<List<AppUser>> getAllUser() {
        return new ResponseEntity<>(accountService.getAllUser(), HttpStatus.OK);
    }
}
