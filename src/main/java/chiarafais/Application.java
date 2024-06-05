package chiarafais;

import chiarafais.dao.EventoDAO;
import chiarafais.entities.Evento;
import chiarafais.entities.EventoType;
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
        System.out.println("**************+*********ES 1***************************");
        Evento matrimonio = new Evento("matrimonio",LocalDate.of(2024, 9, 15),"questa è una descrizione", EventoType.PRIVATO, 500);
        Evento convention = new Evento("convention",LocalDate.of(2022, 10, 30),"questa è una descrizione", EventoType.PUBBLICO, 1000);
        Evento battesimo = new Evento("battesimo",LocalDate.of(2014, 8, 25),"questa è una descrizione", EventoType.PRIVATO, 700);
        Evento anniversario = new Evento("anniversario",LocalDate.of(2021, 9, 10),"questa è una descrizione", EventoType.PUBBLICO, 1200);
        Evento cresima = new Evento("cresima",LocalDate.of(2010, 7, 9),"questa è una descrizione", EventoType.PRIVATO, 200);
        Evento laurea = new Evento("laurea",LocalDate.of(2019, 3, 11),"questa è una descrizione", EventoType.PUBBLICO, 1500);

        //vorrei evitare che si creino ogni volta li stessi eventi ma vorrei comunque tenere il codice! (quindi commento tutti i sd.save())
//        sd.save(matrimonio);
//        sd.save(convention);
//        sd.save(battesimo);
//        sd.save(anniversario);
//        sd.save(cresima);
//        sd.save(laurea);

        


        //esercizio 2: getById = OK
        System.out.println("**************+*********ES 2***************************");
        try {
            Evento provaGetById = sd.findById(4);
            System.out.println(provaGetById);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        //Evento{id=4, titolo='battesimo', data_evento=2014-08-25, descrizione='questa è una descrizione', eventoType=PRIVATO, numero_max_partecipanti=700}

        //esercizio 3: delete = OK
        System.out.println("**************+*********ES 3***************************");
        try {
            sd.delete(202);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        //L'evento cresima è stato correttamente eliminato dal db!


        em.close();
        emf.close();

    }
}
