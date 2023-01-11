package com.mgen.amie;

import com.github.javafaker.Faker;
import com.mgen.amie.entity.UtilisateurEntity;
import com.mgen.amie.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class AmieApplication {

    public static void main(String[] args) {SpringApplication.run(AmieApplication.class, args);}

    @Bean
    CommandLineRunner commandLineRunner(UtilisateurRepository utilisateurRepository) {
        return args -> {
            Faker faker = new Faker();
            for (int i = 0; i <= 20; i++) {
                String prenom = faker.name().firstName();
                String nom = faker.name().lastName();
                String mail = (prenom.substring(0,1) + nom + "@mgen.fr").toLowerCase();
                String motDePasse = faker.internet().password();
                UtilisateurEntity utilisateurEntity = new UtilisateurEntity(prenom, nom, mail, motDePasse);
                utilisateurEntity.setDateDerniereConnexion(LocalDateTime.now());
                utilisateurEntity.setDateDerniereInitialisationMotDePasse(LocalDateTime.now());
                utilisateurRepository.save(utilisateurEntity);
            }
        };
    }

}
