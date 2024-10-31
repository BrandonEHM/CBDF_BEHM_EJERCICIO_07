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
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @ManyToMany(mappedBy = "cursos")
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Leccion> lecciones;
}