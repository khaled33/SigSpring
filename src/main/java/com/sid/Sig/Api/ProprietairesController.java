package com.sid.Sig.Api;

import com.sid.Sig.Entity.Proprietaires;
import com.sid.Sig.Services.PropietaireServiceI;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor

@RestController
public class ProprietairesController {

    private final PropietaireServiceI propietaireServiceI;

    @GetMapping("/Proprietaires/cin/{cin}")
    public Proprietaires getByProprietaireCin(@PathVariable int cin) {
        return propietaireServiceI.getByProprietaireCin(cin);
    }

    @GetMapping("/ProprietairesPage")
    public ResponseEntity<Page<Proprietaires>> getPageProprietaires(Pageable page) {
        return new ResponseEntity<>(propietaireServiceI.getPageProprietaires(page), HttpStatus.OK);
    }

    @PostMapping("/Proprietaires")
    public ResponseEntity<Proprietaires> addProprietaires(@Valid @RequestBody Proprietaires proprietaires) {
        proprietaires.setDatecreation(Instant.now());
        return new ResponseEntity<>(propietaireServiceI.addProprietaires(proprietaires), HttpStatus.CREATED);
    }

    @GetMapping("/Proprietaires")
    public ResponseEntity<List<Proprietaires>> getAllProprietaires() {
        return new ResponseEntity<>(propietaireServiceI.getAllProprietaires(), HttpStatus.OK);
    }

    @GetMapping("/Proprietaires/{id}")
    public ResponseEntity<Proprietaires> getByIdProprietaires(@PathVariable Long id) {
        return new ResponseEntity<>(propietaireServiceI.getByIdProprietaires(id), HttpStatus.OK);
    }

    @PutMapping("/Proprietaires/{id}")
    public ResponseEntity<Proprietaires> updateProprietaires(@Valid @RequestBody Proprietaires proprietaires, @PathVariable Long id) {
        return new ResponseEntity<>(propietaireServiceI.updateProprietaires(proprietaires, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/Proprietaires/{id}")
    public ResponseEntity<Void> deleteProprietaires(@PathVariable Long id) {
        return new ResponseEntity<>(propietaireServiceI.deleteProprietaires(id), HttpStatus.NO_CONTENT);
    }
}
