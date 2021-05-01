package com.sid.Sig.Api;

import com.sid.Sig.Dto.DtoDashboardHead;
import com.sid.Sig.Services.DtoDashboardHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardHeadStatisticController  {
    @Autowired
    DtoDashboardHeadService dtoDashboardHeadService;
@GetMapping("/DashboardHeadStatistic")
    public DtoDashboardHead getDashboardHeadStatistic() {
        return dtoDashboardHeadService.getDashboardHeadStatistic();
    }
}
