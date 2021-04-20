package com.sid.Sig.Services;

import com.sid.Sig.Entity.Vergers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VergersServiceI {
    Vergers addVergers(Vergers Vergers);
    List<Vergers> getAllVergers();
    Page<Vergers> getPageVergers(Pageable page);
    Vergers getByIdVergers(Long id);
    Vergers updateVergers(Vergers Vergers, Long id);
    void deleteVergers(Long id);

}
