package controllers;

import dtos.EmployeDTO;
import entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.Facade;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class Exercice1Controller {
    @Autowired
    Facade facade;

    @GetMapping("")
    public String hello(Model model) {
        return("menu");
    }

    @GetMapping("/manuel")
    public String manuel(Model model) {
        Collection<Employe> employes = facade.findAllManuel();
        model.addAttribute("employes", employes);
        return("listes");
    }

    @GetMapping("/fetchjoin")
    public String fetchjoin(Model model) {
        Collection<Employe> employes = facade.findAllJoin();
        model.addAttribute("employes", employes);
        return("listes");
    }

    @GetMapping("/entitygraph")
    public String entitygraph(Model model) {
        Collection<Employe> employes = facade.findAllEntityGraph();
        model.addAttribute("employes", employes);
        return("listes");
    }

    @GetMapping("/dto")
    public String dtos(Model model) {
        Collection<EmployeDTO> employes = facade.findAllJDTOs();
        model.addAttribute("employes", employes);
        return("listesdto");
    }

}
