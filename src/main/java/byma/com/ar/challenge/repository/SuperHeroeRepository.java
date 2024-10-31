package byma.com.ar.challenge.repository;


import byma.com.ar.challenge.entity.SuperHeroeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperHeroeRepository extends JpaRepository<SuperHeroeEntity, Integer> {
    List<SuperHeroeEntity> findByNameContaining(String name);
}
