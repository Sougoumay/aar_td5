package dtos;

import entities.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

public class EmployeDTO {


    private int idEmp;

    private String prenom;

    private String nom;

    public EmployeDTO() {
    }

    public EmployeDTO(int idEmp, String nom, String prenom) {
        this.idEmp = idEmp;
        this.prenom = prenom;
        this.nom = nom;
    }

    private List<Telephone> telephones;

    private Machine machine;

    private Service service;

    private List<EmployeDTO> membres;

    private Adresse adresse;

    private Pays pays;

    private Set<ProjetDTO> projetsEnCours;

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setMembres(List<EmployeDTO> membres) {
        this.membres = membres;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public void setProjetsEnCours(Set<ProjetDTO> projetsEnCours) {
        this.projetsEnCours = projetsEnCours;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public Machine getMachine() {
        return machine;
    }

    public Service getService() {
        return service;
    }

    public List<EmployeDTO> getMembres() {
        return membres;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Pays getPays() {
        return pays;
    }

    public Set<ProjetDTO> getProjetsEnCours() {
        return projetsEnCours;
    }

    public static class ProjetDTO {
        String code;
        String nom;
        StatutProjet status;
        public ProjetDTO(String codeProjet,String nomProjet, StatutProjet statutProjet) {
            this.code = codeProjet;
            this.nom = nomProjet;
            this.status = statutProjet;
        }

        public String getCode() {
            return code;
        }

        public String getNom() {
            return nom;
        }

        public StatutProjet getStatus() {
            return status;
        }
    }
}
