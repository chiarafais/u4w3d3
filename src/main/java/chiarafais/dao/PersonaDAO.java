package chiarafais.dao;

import chiarafais.entities.Persona;
import chiarafais.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Il sig./ra" + persona.getNome() + persona.getCognome() + "è stato aggiunto con successo");
    }

    public Persona findById(long id) {
        Persona persona = em.find(Persona.class, id);
        if (persona == null) throw new NotFoundException(id);
        return persona;
    }

    public void findAndRemovedById(long id) {
        Persona found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getNome() + found.getCognome() + "è stato eliminato");
    }
}
