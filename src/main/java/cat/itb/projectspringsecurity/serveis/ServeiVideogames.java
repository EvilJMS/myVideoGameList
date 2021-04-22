package cat.itb.projectspringsecurity.serveis;

import cat.itb.projectspringsecurity.Repositoris.RepositoriVideogames;
import cat.itb.projectspringsecurity.model.entitats.Videogame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServeiVideogames {

    @Autowired
    private RepositoriVideogames repositoriVideogames;
    public void addVideogame(Videogame v){
        repositoriVideogames.save(v);
    }

    public List<Videogame> videogameList() {

        List<Videogame> result = new ArrayList<>();
        repositoriVideogames.findAll().forEach(result::add);
        return  result;

    }


    @PostConstruct
    public void init() {
        repositoriVideogames.save(new Videogame("The Binding Of Isaac","Roguelike","Multiplatform",10,"Falta Daño, No Podés."));
        repositoriVideogames.save(new Videogame("Dark Souls","Action","Multiplatform",8,"Has muerto, otra vez"));
        repositoriVideogames.save(new Videogame("Half-Life","ShooterFPS","PC",7,"NUNCA HABRA TERCERA PARTE"));
        repositoriVideogames.save(new Videogame("Yakuza Like a Dragon","RPG","PS4/PC/XBOX",10,"Yakuza per con combates por turnos"));
        repositoriVideogames.save(new Videogame("Yakuza 0","RPG","PS4/PC",9,"El comienzo de una gran saga de videojuegos infravalorados"));

    }
    public Videogame consultaPerId(int id){
        return repositoriVideogames.findById(id).orElse(null);
    }

    public void eliminarPerId(int id){
        repositoriVideogames.delete(consultaPerId(id));
    }

    public void substituir(Videogame e){
        Videogame v = consultaPerId(e.getId());
        v = e;
        repositoriVideogames.save(v);

    }


}
