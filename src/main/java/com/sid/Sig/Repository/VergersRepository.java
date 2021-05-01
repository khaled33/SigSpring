package com.sid.Sig.Repository;

import com.sid.Sig.Entity.Vergers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface VergersRepository extends JpaRepository<Vergers, Long> {
    //    @Query(value="UPDATE vergers SET  geom=ST_GeomFromText(?1) WHERE vergers.id = ?2", nativeQuery = true)
    @Modifying
    @Query(value = "UPDATE vergers SET  geom=ST_GeomFromText(:geom, 4326 )  WHERE id=:id", nativeQuery = true)
    void insertGeom(Long id, String geom);

    Page<Vergers> findAllByOrderById(Pageable page);

    @Query(value="SELECT COUNT(*) FROM vergers", nativeQuery = true)
    Long getCountVergers();
    @Query(value="SELECT SUM(superficies) FROM vergers", nativeQuery = true)
    Double getSurfaceTotal();

    @Query(value="SELECT SUM(rendements) FROM vergers WHERE annee BETWEEN :d1 AND :d2", nativeQuery = true)
    Double getTotalProduction(LocalDate d1, LocalDate d2);


}

