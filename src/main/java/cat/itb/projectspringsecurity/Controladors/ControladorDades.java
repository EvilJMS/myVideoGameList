package cat.itb.projectspringsecurity.Controladors;

import cat.itb.projectspringsecurity.model.entitats.Videogame;
import cat.itb.projectspringsecurity.serveis.ServeiVideogames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorDades {
    @Autowired
    private ServeiVideogames servei;

    @GetMapping("/dades/list")
    public String llistar(Model m){
        m.addAttribute("listVideogames",servei.videogameList());
        return "llistat";
    }

    @GetMapping("/dades/new")
    public String addVideogame(Model m){
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
        m.addAttribute("videogameForm",new Videogame());
        return "afegir";
    }

    @PostMapping("dades/new/submit")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("videogameForm") Videogame v){
        servei.addVideogame(v);
        return "redirect:/dades/list";
    }

    @GetMapping("/dades/edit/{id}")
    public String modifyVideogame(@PathVariable("id") int id, Model m){
        m.addAttribute("videogameForm",servei.consultaPerId(id));
        return "afegir";
    }

    @PostMapping("dades/edit/submit")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String modificarSubmit(@ModelAttribute("videogameForm") Videogame v){
        servei.substituir(v);
        return "redirect:/dades/list";
    }

    @GetMapping( "dades/eliminar/{id}")
    public String removeVideogame(@PathVariable("id") int id){
        servei.eliminarPerId(id);
        return "redirect:/dades/list";
    }




}
