package com.sid.Sig.Api;

import com.sid.Sig.Dto.DtoDashboardHead;
import com.sid.Sig.Services.DtoDashboardHeadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor

@RestController
public class DashboardHeadStatisticController {
 private final     DtoDashboardHeadService dtoDashboardHeadService;

    @GetMapping("/DashboardHeadStatistic")
    public ResponseEntity<DtoDashboardHead> getDashboardHeadStatistic() {
        return new ResponseEntity<>( dtoDashboardHeadService.getDashboardHeadStatistic(), HttpStatus.OK);
    }
}
