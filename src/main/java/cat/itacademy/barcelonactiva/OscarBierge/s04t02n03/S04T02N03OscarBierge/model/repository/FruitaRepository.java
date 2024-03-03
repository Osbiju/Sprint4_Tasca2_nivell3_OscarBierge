package cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge.model.repository;

import cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge.model.domain.Fruita;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitaRepository extends MongoRepository<Fruita, String> {
    //TODO MongoRepository<Fruita, String (per si el id es necesari en string)>
}
