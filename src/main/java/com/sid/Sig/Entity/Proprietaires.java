package com.sid.Sig.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
@Data
@Getter
@Setter
@Entity
@Table(name = "Proprietaires")
public class Proprietaires implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String genre;
    private Date dateDeNaissance;
    private Instant datecreation;
    private String regions;
    private String ville;
    private int codePostal;
    private int cin;
}
