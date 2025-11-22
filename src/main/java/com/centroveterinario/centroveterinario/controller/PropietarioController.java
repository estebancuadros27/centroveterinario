package com.centroveterinario.centroveterinario.controller;


import com.centroveterinario.centroveterinario.model.Propietario;
import com.centroveterinario.centroveterinario.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propietario")
public class PropietarioController {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @GetMapping
    public List<Propietario> getAll(){ return propietarioRepository.findAll();}

    @GetMapping("/{id}")
    public Propietario getById(@PathVariable Long id)
    {
        return propietarioRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Propietario create(@RequestBody Propietario propietario)
    {
        return propietarioRepository.save(propietario);
    }

    @PutMapping("/{id}")
    public Propietario update(@PathVariable Long id, @RequestBody Propietario propietario)
    {
        propietario.setId(id);
        return  propietarioRepository.save(propietario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        propietarioRepository.deleteById(id);
    }
}
