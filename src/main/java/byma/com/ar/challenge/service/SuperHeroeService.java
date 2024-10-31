package byma.com.ar.challenge.service;

import byma.com.ar.challenge.entity.SuperHeroeEntity;
import byma.com.ar.challenge.repository.SuperHeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroeService {

    private final SuperHeroeRepository iSuperheroeRepository;

    @Autowired
    public SuperHeroeService(SuperHeroeRepository superheroeRepository) {
        this.iSuperheroeRepository = superheroeRepository;
    }

    public List<SuperHeroeEntity> getAllSuperHeroes() {
        return iSuperheroeRepository.findAll();
    }


    public List<SuperHeroeEntity> getAllSuperHeroesContains(String target) {
        return null;
    }


    public Optional<SuperHeroeEntity> getSuperHeroeById(Integer id) {
        return iSuperheroeRepository.findById(id);
    }


    public SuperHeroeEntity saveSuperheroe(SuperHeroeEntity superheroe) {
        return  iSuperheroeRepository.save(superheroe);
    }


    public Optional<SuperHeroeEntity> updateSuperheroe(Integer id, SuperHeroeEntity updatedSuperheroe) {
        return iSuperheroeRepository.findById(id)
                .map(existingSuperHeroe -> {
                    existingSuperHeroe.setName(updatedSuperheroe.getName());
                    return iSuperheroeRepository.save(existingSuperHeroe);
                });
    }



    public void deleteSuperheroe(Integer id) {
        iSuperheroeRepository.deleteById(id);
    }
}
