package com.example.demoThymeleaf;

public class Livre {
    private Integer id;
    private String titre;
    private String resume;
    private String editeur;
    private String dateParution;

    public Livre() {
    }

    public Livre(Integer id, String titre, String resume, String editeur, String dateParution) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.editeur = editeur;
        this.dateParution = dateParution;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getDateParution() {
        return dateParution;
    }

    public void setDateParution(String dateParution) {
        this.dateParution = dateParution;
    }
}
