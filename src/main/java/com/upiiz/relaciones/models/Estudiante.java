package com.upiiz.relaciones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotBlank
    private String nombre;

    @NotBlank
    @Email
    private String correo;

    @NotBlank
    private String matricula;

    //Un estudiante tiene un perfil
    @OneToOne(targetEntity = Perfil.class)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    //Un estudiante tiene un tutor
    @ManyToOne(targetEntity = Tutor.class)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    //Un estudiante tiene muchos cursos
    @ManyToMany(targetEntity = Curso.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;
}