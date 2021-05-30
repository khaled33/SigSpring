package com.sid.Sig.Api;

import com.sid.Sig.Entity.Vergers;
import com.sid.Sig.Services.VergersServiceIImpl;
import com.vividsolutions.jts.io.ParseException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Transactional
@AllArgsConstructor

@RestController
public class VergersController {

     private final   VergersServiceIImpl VergersServiceIImpl;

    @GetMapping("/VergersPage")
    public ResponseEntity<Page<Vergers>> getPageVergers(Pageable page) {
        return new ResponseEntity<>(VergersServiceIImpl.getPageVergers(page), HttpStatus.OK);
    }

    @PostMapping("/Vergers")
    public ResponseEntity<Vergers> addVergers(@Valid @RequestBody Vergers vergers) throws ParseException {

        return new ResponseEntity<>( VergersServiceIImpl.addVergers(vergers),HttpStatus.CREATED);
    }

    @GetMapping("/Vergers")
    public ResponseEntity<List<Vergers>> getAllVergers() {
        return new ResponseEntity<>(VergersServiceIImpl.getAllVergers(),HttpStatus.OK);
    }

    @GetMapping("/Vergers/{id}")
    public ResponseEntity<Vergers> getByIdVergers(@PathVariable Long id) {
        return new ResponseEntity<>(VergersServiceIImpl.getByIdVergers(id),HttpStatus.OK);
    }

    @PutMapping("/Vergers/{id}")
    public ResponseEntity<Vergers> updateVergers(@Valid @RequestBody Vergers Vergers, @PathVariable Long id) {
        return new ResponseEntity<>(VergersServiceIImpl.updateVergers(Vergers, id),HttpStatus.CREATED);
    }

    @DeleteMapping("/Vergers/{id}")
    public ResponseEntity<Void> deleteVergers(@PathVariable Long id) {
        return new ResponseEntity<>(VergersServiceIImpl.deleteVergers(id),HttpStatus.NO_CONTENT);
    }
}
