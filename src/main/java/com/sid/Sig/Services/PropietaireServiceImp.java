package com.sid.Sig.Services;

import com.sid.Sig.Repository.ProprietairesRepository;
import com.sid.Sig.Entity.Proprietaires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PropietaireServiceImp implements PropietaireServiceI {

    @Autowired
    private  ProprietairesRepository proprietairesRepository;



    @Override
    public Proprietaires addProprietaires(Proprietaires proprietaires) {
        return proprietairesRepository.save(proprietaires);
    }

    @Override
    public List<Proprietaires> getAllProprietaires() {
        return proprietairesRepository.findAll();
    }

    @Override
    public Page<Proprietaires> getPageProprietaires(Pageable page) {
        return proprietairesRepository.findAllByOrderById(page);
    }

    @Override
    public Proprietaires getByIdProprietaires(Long id) {
        return proprietairesRepository.getOne(id);
    }

    @Override
    public Proprietaires updateProprietaires(Proprietaires proprietaires, Long id) {
        proprietaires.setId(id);
        return proprietairesRepository.save(proprietaires);
    }

    @Override
    public void deleteProprietaires(Long id) {
         proprietairesRepository.deleteById(id);
    }
}
