package com.centroveterinario.centroveterinario.view;

import com.centroveterinario.centroveterinario.model.Propietario;
import com.centroveterinario.centroveterinario.repository.MascotaRepository;
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
public class PropietarioView {
    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @GetMapping("/view/propietario")
    public String viewPropetarios (Model model)
    {
        model.addAttribute("propietario" , propietarioRepository.findAll());
        return "propietario";
    }

    @GetMapping("/view/propietario/form")
    public String form(Model model)
    {
        model.addAttribute("propietario" , new Propietario());
        return  "propietarioform";
    }

    @PostMapping("/view/propietario/save")
    public String save(@ModelAttribute Propietario propietario, RedirectAttributes ra)
    {
        propietarioRepository.save(propietario);
        ra.addFlashAttribute("mensaje" , "Propietario guardado cone exito");
        return  "redirect:/view/propietario";
    }

    @GetMapping("/view/propietario/update/{id}")
    public String edit(@PathVariable Long id, Model model)
    {
        Propietario propietario = propietarioRepository.findById(id).orElse(null);
        model.addAttribute("propietario" , propietario);
        return "propietarioform";
    }

    @PostMapping("/view/propietario/delete/{id}")
    public  String delete(@PathVariable Long id, RedirectAttributes ra)
    {
        long mascotaCount = mascotaRepository.countByPropietarioId(id);
        if (mascotaCount > 0) {
            ra.addFlashAttribute("error", "🚫 No se puede eliminar. Tiene " + mascotaCount + " mascota(s) asociada(s).");
        } else {
            propietarioRepository.deleteById(id);
            ra.addFlashAttribute("success", "Propietario eliminado con éxito");
        }
        return  "redirect:/view/propietario";
    }


}
