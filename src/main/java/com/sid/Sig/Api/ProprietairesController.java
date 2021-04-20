package com.sid.Sig.Api;

import com.sid.Sig.Entity.Proprietaires;
import com.sid.Sig.Services.PropietaireServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
public class ProprietairesController {

    @Autowired
    private  PropietaireServiceI propietaireServiceI;

    @GetMapping("/ProprietairesPage")
    public Page<Proprietaires> getPageProprietaires(Pageable page) {
        return propietaireServiceI.getPageProprietaires(page);
    }

    @PostMapping("/Proprietaires")
    public Proprietaires addProprietaires(@RequestBody Proprietaires proprietaires) {
        proprietaires.setDatecreation(Instant.now());
        return propietaireServiceI.addProprietaires(proprietaires);
    }

    @GetMapping("/Proprietaires")
    public List<Proprietaires> getAllProprietaires() {
        return propietaireServiceI.getAllProprietaires();
    }

    @GetMapping("/Proprietaires/{id}")
    public Proprietaires getByIdProprietaires(@PathVariable Long id) {
        return propietaireServiceI.getByIdProprietaires(id);
    }

    @PutMapping("/Proprietaires/{id}")
    public Proprietaires updateProprietaires(@RequestBody Proprietaires proprietaires, @PathVariable Long id) {
        return propietaireServiceI.updateProprietaires(proprietaires, id);
    }

    @DeleteMapping("/Proprietaires/{id}")
    public void deleteProprietaires(@PathVariable Long id) {
         propietaireServiceI.deleteProprietaires(id);
    }
}
