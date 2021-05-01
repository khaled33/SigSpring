package com.sid.Sig.Api;

import com.sid.Sig.Dto.BarCharts;
import com.sid.Sig.Dto.DtoDashboardHead;
import com.sid.Sig.Dto.PieChar;
import com.sid.Sig.Services.DashboardChartService;
import com.sid.Sig.Services.DtoDashboardHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashboardChartController {
    @Autowired
    private DashboardChartService dashboardChartService;

    @GetMapping("/PieCharSexe")
    public List<PieChar> getDashboardHeadStatistic() {
        return dashboardChartService.getDataPieCharSexe();
    }
    @GetMapping("/BarChartProductionAnnuel")

    public List<BarCharts> getDataBarCharts() {
        return dashboardChartService.getDataBarCharts();
    }
}
