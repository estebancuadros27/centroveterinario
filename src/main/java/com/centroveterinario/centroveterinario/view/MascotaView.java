package com.centroveterinario.centroveterinario.view;

import com.centroveterinario.centroveterinario.model.Mascota; // Asegúrate de tener este modelo
import com.centroveterinario.centroveterinario.repository.MascotaRepository; // Asegúrate de tener este repositorio
import com.centroveterinario.centroveterinario.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MascotaView {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private PropietarioRepository propietarioRepository;


    @GetMapping("/view/mascota")
    public String viewMascotas (Model model)
    {
        model.addAttribute("mascota" , mascotaRepository.findAll());
        return "mascota";
    }


    @GetMapping("/view/mascota/form")
    public String form(Model model)
    {
        model.addAttribute("mascota" , new Mascota());
        model.addAttribute("propietario", propietarioRepository.findAll());
        return  "mascotaForm";
    }

    @PostMapping("/view/mascota/save")
    public String save(@ModelAttribute Mascota mascota, RedirectAttributes ra)
    {
        mascotaRepository.save(mascota);
        ra.addFlashAttribute("success" , "Mascota guardada con éxito");
        return  "redirect:/view/mascota";
    }

    @GetMapping("/view/mascota/update/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        Mascota mascota = mascotaRepository.findById(id).orElse(null);
        model.addAttribute("mascota" , mascota);
        model.addAttribute("propietario", propietarioRepository.findAll());
        return "mascotaForm";
    }

    @PostMapping("/view/mascota/delete/{id}")
    public  String delete(@PathVariable Long id, RedirectAttributes ra)
    {
        mascotaRepository.deleteById(id);
        ra.addFlashAttribute("success"  , "Mascota eliminada con éxito");
        return  "redirect:/view/mascota";
    }
}