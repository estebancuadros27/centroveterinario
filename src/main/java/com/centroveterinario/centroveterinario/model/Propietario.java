package com.centroveterinario.centroveterinario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Table(name = "propietario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El documento es obligatorio")
    @Column(nullable = false)
    private String documento;

    @NotBlank(message = "El telefono es obligatorio")
    @Column(nullable = false)
    private String telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El documento es obligatorio") String getDocumento() {
        return documento;
    }

    public void setDocumento(@NotBlank(message = "El documento es obligatorio") String documento) {
        this.documento = documento;
    }

    public @NotBlank(message = "El telefono es obligatorio") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "El telefono es obligatorio") String telefono) {
        this.telefono = telefono;
    }
}
