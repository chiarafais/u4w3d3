package chiarafais.dao;

import chiarafais.entities.Location;
import chiarafais.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("La location " + location.getNome() + " è stato aggiunto con successo");
    }

    public Location findById(long id) {
        Location location = em.find(Location.class, id);
        if (location == null) throw new NotFoundException(id);
        return location;
    }

    public void findAndRemovedById(long id) {
        Location found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getNome() + "è stato eliminato");
    }
}