package com.sid.Sig.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BarCharts {
    String name;
    BigDecimal value;
}
