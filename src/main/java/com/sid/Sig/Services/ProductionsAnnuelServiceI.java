package com.sid.Sig.Services;

import com.sid.Sig.Entity.ProductionsAnnuel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionsAnnuelServiceI {
    ProductionsAnnuel addProductionsAnnuel(ProductionsAnnuel ProductionsAnnuel);
    List<ProductionsAnnuel> getAllProductionsAnnuel();
    Page<ProductionsAnnuel> getPageProductionsAnnuel(Pageable page);
    ProductionsAnnuel getByIdProductionsAnnuel(Long id);
    ProductionsAnnuel updateProductionsAnnuel(ProductionsAnnuel ProductionsAnnuel, Long id);
    Void deleteProductionsAnnuel(Long id);

}
