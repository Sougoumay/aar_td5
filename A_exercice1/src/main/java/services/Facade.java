package services;

import dtos.EmployeDTO;
import entities.*;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@org.springframework.stereotype.Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    public void createEmployee() {

    }

    @Transactional(readOnly = true)
    public Collection<Employe> findAllManuel() {
        List<Employe> employes = em.createQuery("select e from Employe e").getResultList();
        for (Employe employee : employes) {
            employee.getTelephones().size();
            employee.getMachine();
            if(employee.getService() != null) employee.getService().getMembres().size();
            if(employee.getAdresse() != null) employee.getAdresse().getPays();
            employee.getProjetsEnCours().size();
            System.out.println(employee.toString());
        }
        return employes;
    }

    public Collection<Employe> findAllJoin() {
        List<Employe> employes = em.createQuery("select distinct e from Employe e " +
                "left join fetch e.telephones left join fetch e.machine " +
                //"left join fetch e.service s left join fetch s.membres " +
                "left join fetch e.adresse a left join fetch a.pays " +
                "left join fetch e.projetsEnCours").getResultList();

        return employes;
    }

    public Collection<Employe> findAllEntityGraph() {
        EntityGraph<Employe> eg = em.createEntityGraph(Employe.class);
        eg.addSubgraph("telephones");
        eg.addSubgraph("machine");
        eg.addSubgraph("service").addSubgraph("membres");
        eg.addSubgraph("adresse").addSubgraph("pays");
        eg.addSubgraph("projetsEnCours");

        Query q = em.createQuery("select distinct e from Employe e");
        q.setHint("javax.persistence.loadgraph", eg);

        return q.getResultList();
    }

    public Collection<EmployeDTO> findAllJDTOs() {
        List<Employe> employes = em.createQuery("select distinct e from Employe e").getResultList();
        List<EmployeDTO> dtos = new ArrayList<>();
        for (Employe employee : employes) {
            EmployeDTO dto = new EmployeDTO(employee.getIdEmp(), employee.getNom(), employee.getPrenom());

            List<Telephone> telephones = em.createQuery("select distinct t from Employe e join e.telephones t where e.idEmp=:id")
                    .setParameter("id", employee.getIdEmp())
                    .getResultList();
            dto.setTelephones(telephones);
            dto.setMachine(employee.getMachine());
            Adresse adresse = employee.getAdresse();
            dto.setAdresse(adresse);
            if (adresse != null) {
                Pays pays = adresse.getPays();
                dto.setPays(pays);
            }
            Service service = employee.getService();
            dto.setService(service);
            if (service != null) {
                List<Employe> employeList = em.createQuery("select distinct e from Employe e where e.service.idService=:id and e.idEmp<>idEmp")
                        .setParameter("id",service.getIdService())
                        .setParameter("idEmp",employee.getIdEmp())
                        .getResultList();
                List<EmployeDTO> membres = new ArrayList<>();
                for (Employe e : employeList) {
                    membres.add(new EmployeDTO(e.getIdEmp(),e.getNom(), e.getPrenom()));
                }
                dto.setMembres(membres);
            }
            Set<EmployeDTO.ProjetDTO> projetDTOS = new HashSet<>();
            List<Projet> projets = em.createQuery("select distinct p from Employe e join e.projetsEnCours p where e.idEmp=:id")
                    .setParameter("id",employee.getIdEmp())
                    .getResultList();
            for(Projet projet : projets) {
                projetDTOS.add(new EmployeDTO.ProjetDTO(projet.getCodeProjet(),projet.getNomProjet(),projet.getStatut()));
            }
            dto.setProjetsEnCours(projetDTOS);
            dtos.add(dto);
        }

        return dtos;
    }

}
