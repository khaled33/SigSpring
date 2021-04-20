package com.sid.Sig.Dao;

import com.sid.Sig.Entity.Proprietaires;
import com.sid.Sig.Entity.Vergers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface VergersRepository extends JpaRepository<Vergers,Long> {
//    @Query(value="UPDATE vergers SET  geom=ST_GeomFromText(?1) WHERE vergers.id = ?2", nativeQuery = true)
@Modifying
      @Query(value="UPDATE vergers SET  geom=ST_GeomFromText(:geom, 4326 )  WHERE id=:id", nativeQuery = true)
      void insertGeom(Long id,String geom);


}
