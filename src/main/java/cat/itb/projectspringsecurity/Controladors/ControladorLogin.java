package cat.itb.projectspringsecurity.Controladors;

import cat.itb.projectspringsecurity.model.entitats.Usuari;
import cat.itb.projectspringsecurity.serveis.ServeiUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLogin {
    @Autowired
    private ServeiUsuaris servei;
    @GetMapping("/register")
    public String newUser(Model m){
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
        m.addAttribute("userForm",new Usuari());
        return "register";
    }

    @GetMapping("/login")
    public String login(Model m){
        return "login";
    }



    @PostMapping("/register/add")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String addUser(@ModelAttribute("userForm") Usuari u){
        servei.registerUser(u);
        return "redirect:/";
    }

}
