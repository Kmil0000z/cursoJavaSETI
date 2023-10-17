package co.com.crudtest.jpa;

import co.com.crudtest.model.animal.Animal;
import co.com.crudtest.model.animal.gateways.AnimalRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JpaAnimalImpl implements AnimalRepository {

  private JPARepositoryAdapter jpaRepositoryAdapter;

  @Override
  public void create(Animal animal) {
    String id = UUID.randomUUID().toString();
    animal.setId(id);
    jpaRepositoryAdapter.save(animal);
  }

  @Override
  public Animal read(String id) {
    return jpaRepositoryAdapter.findById(id);
  }

  @Override
  public Animal update(String id, Animal animal) throws Exception {
    Animal animalDb = jpaRepositoryAdapter.findById(id);

    if (animalDb == null) throw new Exception("Animal Not Found : " + id);

    animalDb.setNumPatas(animal.getNumPatas());
    animalDb.setGenero(animal.getGenero());
    animalDb.setEspecie(animal.getEspecie());
    animalDb.setHabitad(animal.getHabitad());
    animalDb.setDomestico(animal.isDomestico());

    jpaRepositoryAdapter.save(animalDb);
    return animalDb;
  }

  @Override
  public void delete(String id) {
    jpaRepositoryAdapter.deleteById(id);
  }

  @Override
  public List<Animal> getAll() {
    return jpaRepositoryAdapter.findAll();
  }
}
