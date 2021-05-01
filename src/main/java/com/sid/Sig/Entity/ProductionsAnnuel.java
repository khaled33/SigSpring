package com.sid.Sig.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ProductionsAnnuel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ProductionsAnnuel implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate AnneeProduction;
    private BigDecimal ProductionValue ;

}
