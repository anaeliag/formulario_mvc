package org.bedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonaController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String nombre, @RequestParam String telefono, Model model) {

        if (telefono.matches("\\d{10}")) {
            model.addAttribute("mensaje", "Datos válidos: Nombre : " + nombre + ", Teléfono: " + telefono);
        } else {
            model.addAttribute("mensaje", "Error: Teléfono inválido");
        }
        return "result";
    }
}

