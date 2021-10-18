package fr.dampierre;

public class Client {
    private Long id;
    private String nom;
    private String mdp;

    public Client(long id, String nom, String mdp) {

        this.id = id;
        this.nom = nom;
        this.mdp = mdp;

    }

    public Long getId() {
        return id;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
