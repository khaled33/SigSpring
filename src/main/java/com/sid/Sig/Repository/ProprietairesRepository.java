package com.sid.Sig.Repository;

import com.sid.Sig.Entity.Proprietaires;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public interface ProprietairesRepository extends JpaRepository<Proprietaires,Long> {

    Proprietaires getByCin(int cin);

    Page<Proprietaires> findAllByOrderById(Pageable page);

    @Query(value="SELECT COUNT(DISTINCT nom) FROM proprietaires", nativeQuery = true)
    Long getCountProprietaires();

    @Query(value="SELECT COUNT (genre) FROM public.proprietaires WHERE genre=:genre", nativeQuery = true)
    Long getCountGenre (String genre);
}
