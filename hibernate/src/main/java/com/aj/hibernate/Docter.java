package com.aj.hibernate;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Docter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer did;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dr_patient", joinColumns = @JoinColumn(name = "did"), inverseJoinColumns = @JoinColumn(name = "pid"))
    private Set<Patient> patients = new HashSet<Patient>();
}
