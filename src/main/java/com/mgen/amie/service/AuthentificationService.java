package com.mgen.amie.service;

import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

    //ecriture de la methode de connexion pour AuthenticationControllee en tant que service
    //pour pouvoir l'utiliser dans le controller
    public boolean connexion(String login, String password) {
        if (login.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }

}
