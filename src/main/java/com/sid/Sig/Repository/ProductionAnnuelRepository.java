package com.sid.Sig.Repository;

import com.sid.Sig.Entity.ProductionsAnnuel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductionAnnuelRepository extends JpaRepository<ProductionsAnnuel, Long> {

    @Query(value = "SELECT * FROM productions_annuel  ORDER BY annee_production desc",nativeQuery = true)
    List<ProductionsAnnuel> findAll();

}

