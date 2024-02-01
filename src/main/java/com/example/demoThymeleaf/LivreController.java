package com.example.demoThymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LivreController {
    private   List<Livre>  listeLivres = new ArrayList<>();

    @GetMapping("livres")
    public String livres(Model model) {


        // liste de livres
        listeLivres.add(new Livre(1, "Introduction à l'Informatique", "Résumé1", "Editeur1", "2022-01-01"));
        listeLivres.add( new Livre(2, "Les Mystères du Cosmos", "Résumé2", "Editeur2", "2022-02-01"));
        listeLivres.add( new Livre(3, "L'Art de la Guerre", "Résumé3", "Editeur3", "2022-03-01"));
        listeLivres.add( new Livre(4, "Voyage au Centre de la Terre", "Résumé4", "Editeur4", "2022-04-01"));
        listeLivres.add( new Livre(5, "Le Portrait de Dorian Gray", "Résumé5", "Editeur5", "2022-05-01"));

        model.addAttribute("listeLivres", listeLivres);

        return "livres"; // livres.html
    }
    @GetMapping("/details")
    public String details(@RequestParam("id") Integer id, Model model) {
        Livre livre = trouverLivreParId(id);
        if (livre != null) {
            model.addAttribute("livre", livre);
            return "details"; // details.html
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
}


