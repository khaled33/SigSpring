package com.sid.Sig.Services;

import com.sid.Sig.Repository.ProductionAnnuelRepository;
import com.sid.Sig.Repository.ProprietairesRepository;
import com.sid.Sig.Repository.VergersRepository;
import com.sid.Sig.Dto.BarCharts;
import com.sid.Sig.Dto.PieChar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  DashboardChartService {
    @Autowired
    private VergersRepository vergersRepository;
    @Autowired
    private ProprietairesRepository proprietairesRepository;
 @Autowired
    private ProductionAnnuelRepository productionAnnuelRepository;

    public List<PieChar> getDataPieCharSexe(){
        List<PieChar> pieChars=  new ArrayList<>();

        pieChars.add(new PieChar("Homme",proprietairesRepository.getCountGenre("Homme")));
        pieChars.add(new PieChar("Femme",proprietairesRepository.getCountGenre("Femme")));

        return pieChars;
    }
    public List<BarCharts> getDataBarCharts(){
        List<BarCharts> BarCharts=  new ArrayList<>();
        productionAnnuelRepository.findAll().forEach(productionsAnnuel -> {
            BarCharts.add(new BarCharts(productionsAnnuel.getAnneeProduction().toString(),productionsAnnuel.getProductionValue()));
        });


        return BarCharts;
    }

}
