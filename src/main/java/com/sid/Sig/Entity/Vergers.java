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


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    private LocalDate annee;
    private Double superficies;
    private Double densites;
    private Integer ageMoyen;
    private Double rendements;
    //     @Column(name = "Point",columnDefinition="Geometry")
     @Column(columnDefinition = "geometry(Point,4326)")
//    @JsonSerialize(using = GeometrySerializer.class)
//    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    @Type(type = "jts_geometry")
//    @Column(columnDefinition = "Geometry", nullable = true)
    private Geometry geom;
     @Transient
    private String geomString;
     @ManyToOne(targetEntity =Proprietaires.class,fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Proprietaires Proprietaires;

    @JsonIgnore
    public void setGeom(Geometry geom) {
        this.geom = geom;
    }
}
