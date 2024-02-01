package com.example.demoThymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LivreController {

    private List<Livre> listeLivres = new ArrayList<>();

    // Initialisation de la liste des livres
    {
        listeLivres.add(new Livre("Introduction à l'Informatique", "Résumé1", "Editeur1", "2022-01-01"));
        listeLivres.add(new Livre("Les Mystères du Cosmos", "Résumé2", "Editeur2", "2022-02-01"));
        listeLivres.add(new Livre("L'Art de la Guerre", "Résumé3", "Editeur3", "2022-03-01"));
        listeLivres.add(new Livre("Voyage au Centre de la Terre", "Résumé4", "Editeur4", "2022-04-01"));
        listeLivres.add(new Livre("Le Portrait de Dorian Gray", "Résumé5", "Editeur5", "2022-05-01"));
    }

    @GetMapping("/livres")
    public String livres(Model model) {
        model.addAttribute("listeLivres", listeLivres);
        return "livres";
    }

    @GetMapping("/details")
    public String details(@RequestParam("id") Integer id, Model model) {
        Livre livre = trouverLivreParId(id);
        if (livre != null) {
            model.addAttribute("livre", livre);
            return "details";
        } else {
            return "livres";
        }
    }

    private Livre trouverLivreParId(Integer id) {
        for (Livre livre : listeLivres) {
            if (livre.getId().equals(id)) {
                return livre;
            }
        }
        return null; // Livre non trouvé
    }

    @GetMapping("/ajoutLivre")
    public String getForm() {
        return "ajoutLivre";
    }

    @PostMapping("/livres")
    public String formulaire(Livre livre, Model model) {
        // Ajoutez le livre à la liste
        listeLivres.add(livre);

        // Mise à jour de la liste des livres
        model.addAttribute("listeLivres", listeLivres);

        // Ajout du nom du livre au modèle
        model.addAttribute("nomLivreAjoute", livre.getTitre());

        System.out.println("Vous avez ajouté : " + livre.getTitre());
        return "livres";
    }
}
