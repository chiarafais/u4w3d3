package chiarafais.entities;

import chiarafais.enums.StatoType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "partecipazioni")

public class Partecipazioni {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Persona partecipazioni;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private StatoType statoType;


    public Partecipazioni() {

    }

    public Partecipazioni( Persona persona, Evento evento, StatoType statoType) {
        this.partecipazioni = persona;
        this.evento = evento;
        this.statoType = statoType;
    }

    public long getId() {
        return id;
    }

    public Persona getPersonaList() {
        return partecipazioni;
    }
    public void setPersonaList(Persona persona) {
        this.partecipazioni = persona;
    }

    public Persona getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(Persona partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoType getStatoType() {
        return statoType;
    }

    public void setStatoType(StatoType statoType) {
        this.statoType = statoType;
    }

    @Override
    public String toString() {
        return "Partecipazioni{" +
                "id=" + id +
                ", evento=" + evento +
                ", statoType=" + statoType +
                '}';
    }
}
