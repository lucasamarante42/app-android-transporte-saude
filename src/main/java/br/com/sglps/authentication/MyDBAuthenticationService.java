package br.com.sglps.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sglps.dao.InterfaceEntradaDAO;
import br.com.sglps.model.Entrada;
 
@Service
public class MyDBAuthenticationService implements UserDetailsService {
 
    @Autowired
    private InterfaceEntradaDAO entradaDAO;
 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	
        Entrada entrada = entradaDAO.findUserInfo(username);
        //System.out.println("UserInfo= " + entrada);
 
        if (entrada == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
         
        // [USER,ADMIN,..]
        List<String> roles= entradaDAO.getUserRoles(username);
         
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
                grantList.add(authority);
            }
        }        
         
        UserDetails userDetails = (UserDetails) new User(entrada.getUserName(), 
                entrada.getPassword(),grantList);
 
        return userDetails;
    }
     
}