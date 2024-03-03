package cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge.controllers;

import cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge.model.domain.Fruita;
import cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruita")
public class FruitaController {


    private final FruitaService fruitaService;

    @Autowired
    public FruitaController(FruitaService fruitaService) {
        this.fruitaService = fruitaService;
    }

    @PostMapping("/add")
    public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(fruitaService.addFruita(fruita));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable String id,
                                               @RequestParam String nouNom,
                                               @RequestParam int novaQuantitatKg){
        Fruita updatedFruita = fruitaService.updateFruita(id, nouNom, novaQuantitatKg);
        if (updatedFruita != null) {
            return ResponseEntity.ok(updatedFruita);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruita> deleteFruitaById(@PathVariable int id) {
        Optional<Fruita> fruitaGetOne = fruitaService.getOneFruita(id);
        if(fruitaGetOne.isEmpty()) {
            return new ResponseEntity<Fruita>(HttpStatus.NOT_FOUND);
        }else {
            fruitaService.deleteFruita(id);
            return new ResponseEntity<Fruita>(HttpStatus.OK);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable int id) {
        Optional<Fruita> fruitaGetOne = fruitaService.getOneFruita(id);
        if(fruitaGetOne.isEmpty()) {
            return new ResponseEntity<Fruita>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Fruita>(fruitaGetOne.get(),HttpStatus.OK);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites(){
        if(fruitaService.getAllFruites().size()==0) {
            return new ResponseEntity<List<Fruita>>(HttpStatus.NO_CONTENT);
        }else
            return new ResponseEntity<List<Fruita>>(fruitaService.getAllFruites(), HttpStatus.OK);
    }
}
