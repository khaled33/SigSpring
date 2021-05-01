package com.sid.Sig.Api;

import com.sid.Sig.Entity.ProductionsAnnuel;
import com.sid.Sig.Services.ProductionsAnnuelServiceI;
import com.sid.Sig.Services.PropietaireServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class ProductionsAnnuelController {

    @Autowired
    private ProductionsAnnuelServiceI productionsAnnuelServiceI;

    @GetMapping("/ProductionsAnnuelPage")
    public Page<ProductionsAnnuel> getPageProductionsAnnuel(Pageable page) {
        return productionsAnnuelServiceI.getPageProductionsAnnuel(page);
    }

    @PostMapping("/ProductionsAnnuel")
    public ProductionsAnnuel addProductionsAnnuel(@RequestBody ProductionsAnnuel proprietaires) {
         return productionsAnnuelServiceI.addProductionsAnnuel(proprietaires);
    }

    @GetMapping("/ProductionsAnnuel")
    public List<ProductionsAnnuel> getAllProductionsAnnuel() {
        return productionsAnnuelServiceI.getAllProductionsAnnuel();
    }

    @GetMapping("/ProductionsAnnuel/{id}")
    public ProductionsAnnuel getByIdProductionsAnnuel(@PathVariable Long id) {
        return productionsAnnuelServiceI.getByIdProductionsAnnuel(id);
    }

    @PutMapping("/ProductionsAnnuel/{id}")
    public ProductionsAnnuel updateProductionsAnnuel(@RequestBody ProductionsAnnuel proprietaires, @PathVariable Long id) {
        return productionsAnnuelServiceI.updateProductionsAnnuel(proprietaires, id);
    }

    @DeleteMapping("/ProductionsAnnuel/{id}")
    public void deleteProductionsAnnuel(@PathVariable Long id) {
        productionsAnnuelServiceI.deleteProductionsAnnuel(id);
    }
}
