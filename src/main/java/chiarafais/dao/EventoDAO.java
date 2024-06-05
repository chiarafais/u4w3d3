package chiarafais.dao;

import chiarafais.entities.Evento;
import chiarafais.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }
    //esercizio 1: cercare di salvare nel db i dati di un evento
    public void save(Evento evento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("L'evento " + evento.getTitolo() + " è stato correttamente salvato nel db!");
    }

    //esercizio 2: getById, prendere i dati di un determinato evento tramite il suo ID univoco
    public Evento findById(long id) {
        Evento evento = em.find(Evento.class, id);
        if (evento == null) throw new NotFoundException(id);
        return evento;
    }

    //esercizio 3: delete, eliminare un evento (credo tramite ID come fatto a lezione)
    public void delete(long id) {
        Evento found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitolo() + " è stato correttamente eliminato dal db!");

    }


}
