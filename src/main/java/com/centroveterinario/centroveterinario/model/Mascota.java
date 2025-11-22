package com.centroveterinario.centroveterinario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "mascota")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la mascota es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "La especie de la mascota es obligatorio")
    @Column(nullable = false)
    private String especie;

    @NotNull(message = "La edad de la mascota es obligatoria")
    @Column(nullable = false)
    private Integer edad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_propietario", nullable = false)
    private Propietario propietario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre de la mascota es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre de la mascota es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "La especie de la mascota es obligatorio") String getEspecie() {
        return especie;
    }

    public void setEspecie(@NotBlank(message = "La especie de la mascota es obligatorio") String especie) {
        this.especie = especie;
    }

    public @NotNull(message = "La edad de la mascota es obligatoria") Integer getEdad() {
        return edad;
    }

    public void setEdad(@NotNull(message = "La edad de la mascota es obligatoria") Integer edad) {
        this.edad = edad;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
