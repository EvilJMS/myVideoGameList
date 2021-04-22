package cat.itb.projectspringsecurity.Repositoris;

import cat.itb.projectspringsecurity.model.entitats.Videogame;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriVideogames extends CrudRepository<Videogame,Integer> {
}
