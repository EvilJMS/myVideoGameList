package cat.itb.projectspringsecurity.Security;

import cat.itb.projectspringsecurity.model.entitats.Usuari;
import cat.itb.projectspringsecurity.serveis.ServeiUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class ElMeuUserDetailsService implements UserDetailsService {
    @Autowired
    private ServeiUsuaris serveiUsuaris;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuari u= serveiUsuaris.consultaPerId(s);
        User.UserBuilder builder=null;
        if(u!=null){
            builder=User.withUsername(s);
            builder.disabled(false);
            builder.password(u.getPassword());

            builder.roles(u.getRol());
        }
        else throw new UsernameNotFoundException("Usuari no trobat");
        return builder.build();
    }
}
