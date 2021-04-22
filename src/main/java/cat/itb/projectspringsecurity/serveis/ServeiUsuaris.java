package cat.itb.projectspringsecurity.serveis;

import cat.itb.projectspringsecurity.Repositoris.RepositoriUsuaris;
import cat.itb.projectspringsecurity.model.entitats.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Service
public class ServeiUsuaris {
    @Autowired
    private RepositoriUsuaris repositoriUsuaris;
    public void registerUser(Usuari u){
        u.setRol("USER");
        u.setPassword(passwordEncoder().encode(u.getPassword()));
        repositoriUsuaris.save(u);
    }
    public Usuari consultaPerId(String s) {
        return repositoriUsuaris.findById(s).orElse(null);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @PostConstruct
    public void init(){
        repositoriUsuaris.save(new Usuari("Montse",passwordEncoder().encode("1234")));
        repositoriUsuaris.save(new Usuari("Josep",passwordEncoder().encode("123456789"),"ADMIN"));
    }




}

