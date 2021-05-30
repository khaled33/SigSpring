package com.sid.Sig.Api;

import com.sid.Sig.Dto.BarCharts;
import com.sid.Sig.Dto.DtoDashboardHead;
import com.sid.Sig.Dto.PieChar;
import com.sid.Sig.Services.DashboardChartService;
import com.sid.Sig.Services.DtoDashboardHeadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor

@RestController
public class DashboardChartController {
     private final DashboardChartService dashboardChartService;

    @GetMapping("/PieCharSexe")
    public ResponseEntity<List<PieChar>>  getDashboardHeadStatistic() {
        return new ResponseEntity<>(dashboardChartService.getDataPieCharSexe(), HttpStatus.OK);
    }

    @GetMapping("/BarChartProductionAnnuel")

    public ResponseEntity<List<BarCharts>> getDataBarCharts() {
        return new ResponseEntity<>( dashboardChartService.getDataBarCharts(), HttpStatus.OK);
    }
}
