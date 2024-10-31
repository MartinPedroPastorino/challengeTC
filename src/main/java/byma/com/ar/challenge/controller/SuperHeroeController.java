package byma.com.ar.challenge.controller;

import byma.com.ar.challenge.annotations.ExecutionTime;
import byma.com.ar.challenge.entity.SuperHeroeEntity;
import byma.com.ar.challenge.service.SuperHeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/superheroes")
public class SuperHeroeController {


    private final SuperHeroeService superHeroeService;

    @Autowired
    public SuperHeroeController(SuperHeroeService superHeroeService) {
        this.superHeroeService = superHeroeService;
    }

    @GetMapping
    @ExecutionTime
    public List<SuperHeroeEntity> getAllSuperHeroes() {
        return superHeroeService.getAllSuperHeroes();
    }

    @GetMapping("/search")
    @ExecutionTime
    public List<SuperHeroeEntity> getSuperHeroesContains(@RequestParam String name) {
        return superHeroeService.getAllSuperHeroesContains(name);
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ResponseEntity<SuperHeroeEntity> getSuperHeroeById(@PathVariable Integer id) {
        Optional<SuperHeroeEntity> superHeroe = superHeroeService.getSuperHeroeById(id);
        return superHeroe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ExecutionTime
    public SuperHeroeEntity saveSuperheroe(@RequestBody SuperHeroeEntity superheroe) {
        return superHeroeService.saveSuperheroe(superheroe);
    }

    @PutMapping("/{id}")
    @ExecutionTime
    public ResponseEntity<SuperHeroeEntity> updateSuperheroe(
            @PathVariable Integer id,
            @RequestBody SuperHeroeEntity updatedSuperheroe) {
        return superHeroeService.updateSuperheroe(id, updatedSuperheroe)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public ResponseEntity<Void> deleteSuperheroe(@PathVariable Integer id) {
        superHeroeService.deleteSuperheroe(id);
        return ResponseEntity.noContent().build();
    }

}
