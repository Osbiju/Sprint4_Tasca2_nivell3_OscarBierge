package cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge.model.domain;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Fruita")
public class Fruita {

    @Id
    private String id; //TODO pot ser STRING!!!!!
    @Field("nom")
    private String nom;
    @Field("quantitatQuilos")
    private int quantitatQuilos;

    public Fruita(){}

    public Fruita(String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    public String getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    } no volem permetre setejar el id, ja que es genera auto

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantitatQuilos() {
        return quantitatQuilos;
    }

    public void setQuantitatQuilos(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
    }


    @Override
    public String toString() {
        return "FruitaEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantitatQuilos=" + quantitatQuilos +
                '}';
    }
}
