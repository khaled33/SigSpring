package com.sid.Sig.Api;


import com.sid.Sig.Entity.AppUser;
import com.sid.Sig.Services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
@AllArgsConstructor

@RestController
public class AccountUserController {
     private final AccountService accountService;
    @PostMapping("/Register")
    public ResponseEntity<AppUser> Register(@Valid @RequestBody AppUser appUser) {

//        List<Role> roleDefault= Collections.singletonList(new Role("Anonyme", null));
//        appUser.setRoles(roleDefault);
                 return new ResponseEntity<>(accountService.saveUser(appUser), HttpStatus.CREATED);


    }
 @PutMapping("/UpdateUser")
    public ResponseEntity<AppUser> UpdateUser(@RequestBody AppUser appUser) {

                  return new ResponseEntity<>(accountService.UpdateUser(appUser), HttpStatus.CREATED);

    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<AppUser> Login(@PathVariable String email) {

        return new ResponseEntity<>(accountService.findUserByEmail(email), HttpStatus.OK);

    }

    @GetMapping("/User")
    public ResponseEntity<AppUser> getCorrentUser() {

        return new ResponseEntity<>(accountService.getCorrentUser(), HttpStatus.OK);

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
