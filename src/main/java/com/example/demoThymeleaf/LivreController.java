package com.example.demoThymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LivreController {

    private final LivreService livreService;

    @Autowired
    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("/livres")
    public String livres(Model model) {
        model.addAttribute("listeLivres", livreService.getListeLivres());
        return "livres";
    }

    @GetMapping("/details")
    public String details(@RequestParam("id") Integer id, Model model) {
        Livre livre = livreService.trouverLivreParId(id);
        if (livre != null) {
            model.addAttribute("livre", livre);
            return "details";
        } else {
            return "livres";
        }
    }

    @GetMapping("/ajoutLivre")
    public String getForm() {
        return "ajoutLivre";
    }

    @PostMapping("/livres")
    public String formulaire(Livre livre, Model model) {
        // Ajoutez le livre à la liste via le service
        livreService.ajouterLivre(livre);

        // Mise à jour de la liste des livres via le service
        model.addAttribute("listeLivres", livreService.getListeLivres());

        // Ajout du nom du livre au modèle
        model.addAttribute("nomLivreAjoute", livre.getTitre());

        System.out.println("Vous avez ajouté : " + livre.getTitre());
        return "livres";
    }
}
