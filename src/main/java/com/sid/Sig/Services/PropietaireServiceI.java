package com.sid.Sig.Services;

import com.sid.Sig.Entity.Proprietaires;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropietaireServiceI {
    Proprietaires addProprietaires(Proprietaires proprietaires);
    List<Proprietaires> getAllProprietaires();
    Page<Proprietaires> getPageProprietaires(Pageable page);
    Proprietaires getByProprietaireCin(int cin);
    Proprietaires getByIdProprietaires(Long id);
    Proprietaires updateProprietaires(Proprietaires proprietaires,Long id);
    Void deleteProprietaires(Long id);

}
