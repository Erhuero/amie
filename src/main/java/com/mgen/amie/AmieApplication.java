package com.mgen.amie;

import com.github.javafaker.Faker;
import com.mgen.amie.entity.EvenementEntity;
import com.mgen.amie.entity.UtilisateurEntity;
import com.mgen.amie.model.Evenement;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.mgen.amie.model.Lieu;
import com.mgen.amie.repository.EvenementRepository;
import com.mgen.amie.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@CrossOrigin
public class AmieApplication {

    public static void main(String[] args) {SpringApplication.run(AmieApplication.class, args);}


    @Bean
    CommandLineRunner commandLineRunner(EvenementRepository evenementRepository, UtilisateurRepository utilisateurRepository) {
        return args -> {
            Faker faker = new Faker();
            //genererEvenements(evenementRepository, faker);
            genererUtilisateurs(utilisateurRepository, faker);
        };
    }

    private void genererEvenements(EvenementRepository evenementRepository, Faker faker) {
        for (int i = 0; i < 10; i++) {
            EvenementEntity event = new EvenementEntity(
                    faker.book().title(),
                    faker.lorem().sentence(),
                    LocalDate.now().toString(),
                    LocalDate.now().toString(),
                    LocalTime.now(),
                    LocalTime.now().toString(),
                    faker.internet().url(),
                    faker.internet().url(),
                    null,
                    null);
            evenementRepository.save(event);
        }
    }

    private void genererUtilisateurs(UtilisateurRepository utilisateurRepository, Faker faker) {
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
    }

}
