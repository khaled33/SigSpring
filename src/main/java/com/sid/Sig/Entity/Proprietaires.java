package com.sid.Sig.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
@Data
@Getter
@Setter
@Entity
@Table(name = "Proprietaires",indexes ={@Index(name = "i_Cin", columnList = "cin")} )
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proprietaires implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    @NotNull(message = " nom ne peut pas être nul")
    private String nom;

    @NotNull(message = " prenom ne peut pas être nul")
    private String prenom;

    @NotNull(message = " genre ne peut pas être nul")
    private String genre;

    @NotNull(message = " Rendements ne peut pas être nul")
    private Date dateDeNaissance;

    @JsonIgnore
    private Instant datecreation;
    @NotNull(message = " regions ne peut pas être nul")
    private String regions;

    @NotNull(message = " ville ne peut pas être nul")
    private String ville;

    @NotNull(message = " codePostal ne peut pas être nul")
    @Positive(message = "codePostal  Doit être un nombre positive")
    private int codePostal;

    @NotNull(message = " cin ne peut pas être nul")
    @Positive(message = "cin  Doit être un nombre positive")
    @Column(unique = true)
    private int cin;
    private String ajoutePar;

}
