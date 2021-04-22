package cat.itb.projectspringsecurity.Repositoris;

import cat.itb.projectspringsecurity.model.entitats.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends CrudRepository<Usuari,String> {
}
