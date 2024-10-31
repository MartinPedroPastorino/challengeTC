package byma.com.ar.challenge.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="SUPERHEROES")
@Data
@Getter
@Setter
@NoArgsConstructor
public class SuperHeroeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    public SuperHeroeEntity(String name) {
        this.name = name;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
