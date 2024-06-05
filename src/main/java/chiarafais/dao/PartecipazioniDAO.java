package chiarafais.dao;

import chiarafais.entities.Partecipazioni;
import chiarafais.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioniDAO {
    private final EntityManager em;

    public PartecipazioniDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazioni partecipazioni) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazioni);
        transaction.commit();
        System.out.println("La partecipazione con id" + partecipazioni.getId() + "è stato aggiunto con successo");
    }

    public Partecipazioni findById(long id) {
        Partecipazioni partecipazioni = em.find(Partecipazioni.class, id);
        if (partecipazioni == null) throw new NotFoundException(id);
        return partecipazioni;
    }

    public void findAndRemovedById(long id) {
        Partecipazioni found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getId() + "è stato eliminato");
    }
}
