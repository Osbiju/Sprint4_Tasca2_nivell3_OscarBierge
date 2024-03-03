package cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge.model.services;

import cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge.model.domain.Fruita;
import cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {

    private final FruitaRepository fruitaRepository; //nos permite utilizar los metodos JPA

    @Autowired //inyectamos dependencia
    public FruitaService(FruitaRepository fruitaRepository) {
        this.fruitaRepository = fruitaRepository;
    }

    //add
    public Fruita addFruita(Fruita fruita){
        return fruitaRepository.save(fruita);
    }
    //update
    public Fruita updateFruita(String id, String nouNom, int novaQuantitatKg){
        Optional<Fruita> fruitaCorrecta = fruitaRepository.findById(id);

        if (fruitaCorrecta.isPresent()){
            Fruita fruitaPerUpdate = fruitaCorrecta.get();
            fruitaPerUpdate.setNom(nouNom);
            fruitaPerUpdate.setQuantitatQuilos(novaQuantitatKg);
            fruitaRepository.save(fruitaPerUpdate);
            return fruitaPerUpdate;
        } else {
            return null; //podriamos crear una excepcion personalizada para una fruitanotfound
        }
    }
    //Delete
    public void deleteFruita(int id){
        fruitaRepository.deleteById(String.valueOf(id));
    }
    //getOne
    public Optional<Fruita> getOneFruita(int id){
        return fruitaRepository.findById(String.valueOf(Math.toIntExact(id)));
    }
    //getAll
    public List<Fruita> getAllFruites(){
        return fruitaRepository.findAll();
    }
}
