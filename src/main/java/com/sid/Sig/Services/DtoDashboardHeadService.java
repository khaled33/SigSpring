package com.sid.Sig.Services;

import com.sid.Sig.Repository.ProprietairesRepository;
import com.sid.Sig.Repository.VergersRepository;
import com.sid.Sig.Dto.DtoDashboardHead;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@AllArgsConstructor

@Service
public class DtoDashboardHeadService {
     private final VergersRepository vergersRepository;
     private final ProprietairesRepository proprietairesRepository;

    public DtoDashboardHead getDashboardHeadStatistic(){
        DtoDashboardHead dashboardHead = new DtoDashboardHead();
        dashboardHead.setCountProprietaires(proprietairesRepository.getCountProprietaires());
        dashboardHead.setCountVergers(vergersRepository.getCountVergers());
        dashboardHead.setSurfaceTotal(vergersRepository.getSurfaceTotal());
        int date =LocalDate.now().getYear();
        StringBuilder interval1 = new StringBuilder(),interval2=new StringBuilder();

        interval1.append(date+"-01-01");
        interval2.append(date+"-12-30");
        dashboardHead.setTotalProduction(vergersRepository.getTotalProduction(LocalDate.parse(interval1),LocalDate.parse(interval2)));

        return dashboardHead;
    }

}
