package com.sid.Sig.Services;

import com.sid.Sig.Repository.ProductionAnnuelRepository;
import com.sid.Sig.Entity.ProductionsAnnuel;
import com.sid.Sig.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionsAnnuelServiceIImpl extends GetCorrentUser implements ProductionsAnnuelServiceI {

    @Autowired
    private ProductionAnnuelRepository productionAnnuelRepository;

    @Override
    public ProductionsAnnuel addProductionsAnnuel(ProductionsAnnuel ProductionsAnnuel) {
        ProductionsAnnuel.setAjoutePar(getCorrentUser().getLastname() + " " + getCorrentUser().getFirstname());
        return productionAnnuelRepository.save(ProductionsAnnuel);
    }

    @Override
    public List<ProductionsAnnuel> getAllProductionsAnnuel() {
        return productionAnnuelRepository.findAll();
    }

    @Override
    public Page<ProductionsAnnuel> getPageProductionsAnnuel(Pageable page) {
        return productionAnnuelRepository.findAll(page);
    }

    @Override
    public ProductionsAnnuel getByIdProductionsAnnuel(Long id) {
        return productionAnnuelRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Productions Annuel n'existe pas "+id);
        });
    }

    @Override
    public ProductionsAnnuel updateProductionsAnnuel(ProductionsAnnuel ProductionsAnnuel, Long id) {
        ProductionsAnnuel.setId(id);
        return productionAnnuelRepository.save(ProductionsAnnuel);
    }

    @Override
    public Void deleteProductionsAnnuel(Long id) {
        productionAnnuelRepository.deleteById(id);

        return null;
    }
}
