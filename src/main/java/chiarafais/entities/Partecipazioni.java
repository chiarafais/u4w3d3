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

    @ManyToMany
    @JoinTable(name = "persona_partecipazioni", joinColumns = @JoinColumn(name = "partecipazioni_id"), inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private List<Persona> partecipazioni;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private StatoType statoType;


    public Partecipazioni() {

    }

    public Partecipazioni( List<Persona> partecipazioni, Evento evento, StatoType statoType) {
        this.partecipazioni = partecipazioni;
        this.evento = evento;
        this.statoType = statoType;
    }

    public long getId() {
        return id;
    }

    public List<Persona> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Persona> partecipazioni) {
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
