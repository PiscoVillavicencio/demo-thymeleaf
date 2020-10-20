package com.example.demo.controller;

import com.example.demo.converter.PersonaConverter;
import com.example.demo.model.dto.PersonaDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    UserDto globalUser;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private PersonaConverter personaConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("opcion", "Personas");
        model.addAttribute("user", globalUser);
        model.addAttribute("personas", personaConverter.toListDto(personaService.listAll()));
        return "persona/listar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("opcion", "Editar Persona");
        model.addAttribute("user", globalUser);

        return "persona/formulario";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("opcion", "Nueva Persona");
        model.addAttribute("user", globalUser);

        return "persona/formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(PersonaDto dto, Model model) throws Exception {


        return "redirect:/persona/";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {
        personaService.delete(id);
        return "redirect:/persona/";
    }

}
