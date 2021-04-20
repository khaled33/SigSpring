package com.sid.Sig.Dao;

import com.sid.Sig.Entity.Proprietaires;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;

@Service
public interface ProprietairesRepository extends JpaRepository<Proprietaires,Long> {
}
