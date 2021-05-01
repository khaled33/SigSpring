package com.sid.Sig.Services;

import com.sid.Sig.Repository.VergersRepository;
import com.sid.Sig.Entity.Vergers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class VergersServiceIImpl implements VergersServiceI {
    @Autowired
    private VergersRepository  VergersRepository;

    @Override
    @Transactional
    public Vergers addVergers(Vergers vergers) {
        vergers.setGeom(null);

        Long id= VergersRepository.save(vergers).getId();

        VergersRepository.insertGeom(id,vergers.getGeomString());
        return vergers;
    }

    @Override
    public List<Vergers> getAllVergers() {
        return VergersRepository.findAll();
    }

    @Override
    public Page<Vergers> getPageVergers(Pageable page) {
        return VergersRepository.findAllByOrderById(page);
    }

    @Override
    public Vergers getByIdVergers(Long id) {
        return VergersRepository.getOne(id);
    }

    @Override
    @Transactional
    public Vergers updateVergers(Vergers Vergers, Long id) {
        Vergers.setId(id);
        Vergers.setGeom(null);

         VergersRepository.save(Vergers);

        VergersRepository.insertGeom(id,Vergers.getGeomString());
        return Vergers;
     }

    @Override
    public void deleteVergers(Long id) {
        VergersRepository.deleteById(id);
    }
}
