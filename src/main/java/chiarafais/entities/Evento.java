package chiarafais.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "evento")

public class Evento {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "titolo")
    private String titolo;
    @Column(name = "data_evento")
    private LocalDate data_evento;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventoType eventoType;
    @Column(name = "numero_max_partecipanti")
    private int numero_max_partecipanti;

    public Evento() {

    }

    public Evento(String titolo, LocalDate data_evento,String descrizione, EventoType eventoType, int numero_max_partecipanti) {
        this.titolo = titolo;
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.eventoType = eventoType;
        this.numero_max_partecipanti = numero_max_partecipanti;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventoType getEventoType() {
        return eventoType;
    }

    public void setEventoType(EventoType eventoType) {
        this.eventoType = eventoType;
    }

    public int getNumero_max_partecipanti() {
        return numero_max_partecipanti;
    }

    public void setNumero_max_partecipanti(int numero_max_partecipanti) {
        this.numero_max_partecipanti = numero_max_partecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", eventoType=" + eventoType +
                ", numero_max_partecipanti=" + numero_max_partecipanti +
                '}';
    }
}
