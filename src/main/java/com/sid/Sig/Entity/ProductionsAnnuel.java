package com.sid.Sig.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
    @NotNull(message = " AnneeProduction ne peut pas être nul")
    @Positive(message = "AnneeProduction  Doit être un nombre positive")
    private String AnneeProduction;

    @NotNull(message = " ProductionValue ne peut pas être nul")
    @Positive(message = "ProductionValue  Doit être un nombre positive")
    private BigDecimal ProductionValue ;

    private String ajoutePar;


}
