package com.sid.Sig.Api;

import com.sid.Sig.Dao.VergersRepository;
import com.sid.Sig.Entity.Proprietaires;
import com.sid.Sig.Entity.Vergers;
import com.sid.Sig.Services.PropietaireServiceI;
import com.sid.Sig.Services.VergersServiceIImpl;
import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
@Transactional

@RestController
public class VergersController {

    @Autowired
    private   VergersServiceIImpl VergersServiceIImpl;

//    @GetMapping("/vergerPage")
//    public Page<Proprietaires> getPageProprietaires(Pageable page) {
//        return propietaireServiceI.getPageProprietaires(page);
//    }

    @PostMapping("/vergers")
    public Vergers addVergers(@RequestBody Vergers vergers) throws ParseException {

        return VergersServiceIImpl.addVergers(vergers);
    }

//    @GetMapping("/vergers")
//    public List<Vergers> getAllProprietaires() {
//        return vergersRepository.findAll();
//    }
//
//    @GetMapping("/Proprietaires/{id}")
//    public Proprietaires getByIdProprietaires(@PathVariable Long id) {
//        return propietaireServiceI.getByIdProprietaires(id);
//    }
//
//    @PutMapping("/Proprietaires/{id}")
//    public Proprietaires updateProprietaires(@RequestBody Proprietaires proprietaires, @PathVariable Long id) {
//        return propietaireServiceI.updateProprietaires(proprietaires, id);
//    }
//
//    @DeleteMapping("/Proprietaires/{id}")
//    public void deleteProprietaires(@PathVariable Long id) {
//         propietaireServiceI.deleteProprietaires(id);
//    }
}
