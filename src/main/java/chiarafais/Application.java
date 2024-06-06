package chiarafais;

import chiarafais.dao.EventoDAO;
import chiarafais.dao.LocationDAO;
import chiarafais.dao.PartecipazioniDAO;
import chiarafais.dao.PersonaDAO;
import chiarafais.entities.Evento;
import chiarafais.entities.Location;
import chiarafais.entities.Partecipazioni;
import chiarafais.entities.Persona;
import chiarafais.enums.EventoType;
import chiarafais.enums.SessoType;
import chiarafais.enums.StatoType;
import chiarafais.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("u4w3d2");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);

        //esercizio 1: cercare di salvare nel db i dati di un evento = OK
//        System.out.println("**************+*********ES 1***************************");
//        Evento matrimonio = new Evento("matrimonio",LocalDate.of(2024, 9, 15),"questa è una descrizione", EventoType.PRIVATO, 500);
//        Evento convention = new Evento("convention",LocalDate.of(2022, 10, 30),"questa è una descrizione", EventoType.PUBBLICO, 1000);
//        Evento battesimo = new Evento("battesimo",LocalDate.of(2014, 8, 25),"questa è una descrizione", EventoType.PRIVATO, 700);
//        Evento anniversario = new Evento("anniversario",LocalDate.of(2021, 9, 10),"questa è una descrizione", EventoType.PUBBLICO, 1200);
//        Evento cresima = new Evento("cresima",LocalDate.of(2010, 7, 9),"questa è una descrizione", EventoType.PRIVATO, 200);
//        Evento laurea = new Evento("laurea",LocalDate.of(2019, 3, 11),"questa è una descrizione", EventoType.PUBBLICO, 1500);


        //vorrei evitare che si creino ogni volta li stessi eventi ma vorrei comunque tenere il codice! (quindi commento tutti i sd.save())
  //  sd.save(matrimonio);
//        sd.save(convention);
//        sd.save(battesimo);
//        sd.save(anniversario);
//        sd.save(cresima);
//        sd.save(laurea);

        


        //esercizio 2: getById = OK
//        System.out.println("**************+*********ES 2***************************");
//        try {
//            Evento provaGetById = sd.findById(4);
//            System.out.println(provaGetById);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//        //Evento{id=4, titolo='battesimo', data_evento=2014-08-25, descrizione='questa è una descrizione', eventoType=PRIVATO, numero_max_partecipanti=700}
//
//        //esercizio 3: delete = OK
//        System.out.println("**************+*********ES 3***************************");
//        try {
//            sd.delete(202);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
        //L'evento cresima è stato correttamente eliminato dal db!


        Location location = new Location("Provaaa", "latina");
        LocationDAO locationdb = new LocationDAO(em);
//      locationdb.save(location);
        Location locationfound = locationdb.findById(1);

        Persona persona1 = new Persona("Aldo", "Baglio", "aldobaglio@gmail.com", LocalDate.of(1982, 9, 15), SessoType.MASCHIO);
        PersonaDAO personaDao1 = new PersonaDAO(em);
//        personaDao1.save(persona1);

        Evento evento = new Evento("L'isola che non c'è", LocalDate.of(2024, 07, 05), "evento per bambini", EventoType.PUBBLICO, 50, locationfound);
        EventoDAO evento1 = new EventoDAO(em);
//         evento1.save(evento);

      Evento eventofound = evento1.findById(1);
      Persona personafound = personaDao1.findById(1);

       Partecipazioni partecipazione = new Partecipazioni(personafound, eventofound, StatoType.DA_CONFERMARE);
       PartecipazioniDAO partecipazione1 = new PartecipazioniDAO(em);
        partecipazione1.save(partecipazione);
       partecipazione1.findAndRemovedById(1);

        em.close();
        emf.close();

    }
}
