package com.centroveterinario.centroveterinario.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexView {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
