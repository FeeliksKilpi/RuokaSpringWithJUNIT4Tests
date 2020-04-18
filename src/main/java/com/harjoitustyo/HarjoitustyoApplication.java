package com.harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.harjoitustyo.domain.Ravintola;
import com.harjoitustyo.domain.RavintolaRepository;
import com.harjoitustyo.domain.Ruoka;
import com.harjoitustyo.domain.RuokaRepository;
import com.harjoitustyo.domain.UserCred;
import com.harjoitustyo.domain.UserCredRepository;



@SpringBootApplication
public class HarjoitustyoApplication {
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
			
	}
	@Bean
	public CommandLineRunner ruokasuosikit(RuokaRepository rrepository, RavintolaRepository ravrepository, UserCredRepository urepository) {
		return (args) -> {
			
		/*	urepository.deleteAll(); */
		/*	ravrepository.save(new Ravintola("Ravintola Kalasatama", "lounasravintola", "Kalasatama", 5));
			ravrepository.save(new Ravintola("Have a Java", "kahvila", "Pasila", 2));
			ravrepository.save(new Ravintola("Jätkäbaari", "baari", "Jätkäsaari", 3)); */
			
			System.out.println(ravrepository.findAll());
			
			log.info("save a couple of foods"); //logger tuottaa lokia ohjelman toiminnasta
			rrepository.save(new Ruoka("Paella", "Merenelävät", "-", 7.90, ravrepository.findByRavintolaNimi("Jätkäbaari").get(0)));
			/*	urepository.deleteAll();
			rrepository.save(new Ruoka("Savulohisalaatti", "Merenelävät", "M, L, G", 8.90, ravrepository.findByRavintolaNimi("Ravintola Kalasatama").get(0)));
			rrepository.save(new Ruoka("Chorizoa ja Manchego-juustoa", "Liha", "L, M", 9.90, ravrepository.findByRavintolaNimi("Ravintola Kalasatama").get(0)));
			rrepository.save(new Ruoka("Paella", "Merenelävät", "-", 7.90, ravrepository.findByRavintolaNimi("Jätkäbaari").get(0)));
			rrepository.save(new Ruoka("Paistettua turskaa", "Merenelävät", "-", 6.90, ravrepository.findByRavintolaNimi("Jätkäbaari").get(0)));
			rrepository.save(new Ruoka("Soijatortilla", "Vegaani", "G", 4.90, ravrepository.findByRavintolaNimi("Ravintola Kalasatama").get(0)));
			rrepository.save(new Ruoka("Berliininmunkki", "Jälkiruoka", "M", 1.50, ravrepository.findByRavintolaNimi("Have a Java").get(0))); */
			//repository.deleteAll(); //Poistaa kaikki kirjat mikäli niin halutaan
			
			// Create users: admin/admin user/user
			UserCred user1 = new UserCred("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			UserCred user2 = new UserCred("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			urepository.deleteAll();
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all foods");
			for (Ruoka ruoka : rrepository.findAll()) {
				log.info(ruoka.toString());
			}

		};
	}
	
}
