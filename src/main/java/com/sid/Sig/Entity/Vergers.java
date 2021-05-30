package com.sid.Sig.Entity;


import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Geometry;

import javax.validation.constraints.NotNull;


import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Vergers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Vergers implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "L'annee ne peut pas être nul")
    private LocalDate annee;

    @NotNull(message = " Superficies ne peut pas être nul")
    @Positive(message = "superficies  Doit être un nombre positive")
    private Double superficies;

    @NotNull(message = " Densites ne peut pas être nul")
    @Positive(message = "Densites  Doit être un nombre positive")
    private Double densites;

    @NotNull(message = " L'age Moyen ne peut pas être nul")
    @Positive(message = "L'age Moyen  Doit être un nombre positive")
    private Integer ageMoyen;

    @NotNull(message = " Rendements ne peut pas être nul")
    @Positive(message = "Rendements  Doit être un nombre positive")
    private Double rendements;

    private String ajoutePar;
    //     @Column(name = "Point",columnDefinition="Geometry")
    @Column(columnDefinition = "geometry(Point,4326)")
//    @JsonSerialize(using = GeometrySerializer.class)
//    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    @Type(type = "jts_geometry")
//    @Column(columnDefinition = "Geometry", nullable = true)
    private Geometry geom;
    @Transient
    @NotNull(message = " geom ne peut pas être nul")
    private String geomString;
    @ManyToMany(targetEntity = Proprietaires.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Collection<Proprietaires> Proprietaires;

    @JsonIgnore
    public void setGeom(Geometry geom) {
        this.geom = geom;
    }
}
