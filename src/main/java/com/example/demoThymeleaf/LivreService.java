package com.example.demoThymeleaf;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivreService {

    private List<Livre> listeLivres = new ArrayList<>();

    // Initialisation de la liste des livres
    {
        listeLivres.add(new Livre("Introduction à l'Informatique", "Résumé1", "Editeur1", "2022-01-01"));
        listeLivres.add(new Livre("Les Mystères du Cosmos", "Résumé2", "Editeur2", "2022-02-01"));
        listeLivres.add(new Livre("L'Art de la Guerre", "Résumé3", "Editeur3", "2022-03-01"));
        listeLivres.add(new Livre("Voyage au Centre de la Terre", "Résumé4", "Editeur4", "2022-04-01"));
        listeLivres.add(new Livre("Le Portrait de Dorian Gray", "Résumé5", "Editeur5", "2022-05-01"));
    }

    public List<Livre> getListeLivres() {
        return listeLivres;
    }

    public Livre trouverLivreParId(Integer id) {
        for (Livre livre : listeLivres) {
            if (livre.getId().equals(id)) {
                return livre;
            }
        }
        return null; // Livre non trouvé
    }

    public void ajouterLivre(Livre livre) {
        listeLivres.add(livre);
    }
}
