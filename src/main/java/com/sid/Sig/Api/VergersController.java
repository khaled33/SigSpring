package com.sid.Sig.Api;

import com.sid.Sig.Dao.VergersRepository;
import com.sid.Sig.Entity.Vergers;
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

    @GetMapping("/VergersPage")
    public Page<Vergers> getPageVergers(Pageable page) {
        return VergersServiceIImpl.getPageVergers(page);
    }

    @PostMapping("/Vergers")
    public Vergers addVergers(@RequestBody Vergers vergers) throws ParseException {

        return VergersServiceIImpl.addVergers(vergers);
    }

    @GetMapping("/Vergers")
    public List<Vergers> getAllVergers() {
        return VergersServiceIImpl.getAllVergers();
    }

    @GetMapping("/Vergers/{id}")
    public Vergers getByIdVergers(@PathVariable Long id) {
        return VergersServiceIImpl.getByIdVergers(id);
    }

    @PutMapping("/Vergers/{id}")
    public Vergers updateVergers(@RequestBody Vergers Vergers, @PathVariable Long id) {
        return VergersServiceIImpl.updateVergers(Vergers, id);
    }

    @DeleteMapping("/Vergers/{id}")
    public void deleteVergers(@PathVariable Long id) {
        VergersServiceIImpl.deleteVergers(id);
    }
}
