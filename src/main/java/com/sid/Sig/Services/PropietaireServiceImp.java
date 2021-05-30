package com.sid.Sig.Services;

import com.sid.Sig.Repository.AppUsersRepository;
import com.sid.Sig.Repository.ProprietairesRepository;
import com.sid.Sig.Entity.Proprietaires;
import com.sid.Sig.config.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PropietaireServiceImp extends GetCorrentUser implements PropietaireServiceI {


    @Autowired
    private   ProprietairesRepository proprietairesRepository;




    @Override
    public Proprietaires addProprietaires(Proprietaires proprietaires) {
        proprietaires.setAjoutePar(getCorrentUser().getLastname()+" "+getCorrentUser().getFirstname());
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
    public Proprietaires getByProprietaireCin(int cin) {
        return proprietairesRepository.getByCin(cin);
    }

    @Override
    public Proprietaires getByIdProprietaires(Long id) {
        return proprietairesRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("le Proprietaire  n'existe pas "+id);
        });
    }

    @Override
    public Proprietaires updateProprietaires(Proprietaires proprietaires, Long id) {
        proprietaires.setId(id);
        return proprietairesRepository.save(proprietaires);
    }

    @Override
    public Void deleteProprietaires(Long id) {
         proprietairesRepository.deleteById(id);
         return null;
    }
}
