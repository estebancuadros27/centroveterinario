package com.centroveterinario.centroveterinario.repository;

import com.centroveterinario.centroveterinario.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    long countByPropietarioId(Long propietarioId);
}
