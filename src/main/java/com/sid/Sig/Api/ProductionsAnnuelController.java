package com.sid.Sig.Api;

import com.sid.Sig.Entity.ProductionsAnnuel;
import com.sid.Sig.Services.ProductionsAnnuelServiceI;
import com.sid.Sig.Services.PropietaireServiceI;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
@AllArgsConstructor

@RestController
public class ProductionsAnnuelController {

     private final ProductionsAnnuelServiceI productionsAnnuelServiceI;

    @GetMapping("/ProductionsAnnuelPage")
    public ResponseEntity<Page<ProductionsAnnuel>> getPageProductionsAnnuel(Pageable page) {
        return new ResponseEntity<>(productionsAnnuelServiceI.getPageProductionsAnnuel(page), HttpStatus.OK);
    }

    @PostMapping("/ProductionsAnnuel")
    public ResponseEntity<ProductionsAnnuel> addProductionsAnnuel(@Valid @RequestBody ProductionsAnnuel proprietaires) {
         return  new ResponseEntity<>(productionsAnnuelServiceI.addProductionsAnnuel(proprietaires),HttpStatus.CREATED);
    }

    @GetMapping("/ProductionsAnnuel")
    public ResponseEntity<List<ProductionsAnnuel>> getAllProductionsAnnuel() {
        return  new ResponseEntity<>(productionsAnnuelServiceI.getAllProductionsAnnuel(),HttpStatus.OK);
    }

    @GetMapping("/ProductionsAnnuel/{id}")
    public ResponseEntity<ProductionsAnnuel> getByIdProductionsAnnuel(@PathVariable Long id) {
        return    new ResponseEntity<>(productionsAnnuelServiceI.getByIdProductionsAnnuel(id),HttpStatus.OK);
    }

    @PutMapping("/ProductionsAnnuel/{id}")
    public ResponseEntity<ProductionsAnnuel> updateProductionsAnnuel(@Valid @RequestBody ProductionsAnnuel proprietaires, @PathVariable Long id) {
        return new ResponseEntity<>(productionsAnnuelServiceI.updateProductionsAnnuel(proprietaires, id),HttpStatus.CREATED);
    }

    @DeleteMapping("/ProductionsAnnuel/{id}")
    public ResponseEntity<Void> deleteProductionsAnnuel(@PathVariable Long id) {
        return new ResponseEntity<>( productionsAnnuelServiceI.deleteProductionsAnnuel(id),HttpStatus.NO_CONTENT);
    }
}
