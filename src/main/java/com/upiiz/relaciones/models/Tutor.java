package com.upiiz.relaciones.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String escolaridad;

    @OneToMany(mappedBy = "tutor", fetch = FetchType.LAZY)
    private List<Estudiante> estudiantes;
}
