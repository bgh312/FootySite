package hh.swd20.FootySite;

import hh.swd20.FootySite.domain.Team;
import hh.swd20.FootySite.domain.TeamRepository;
import hh.swd20.FootySite.domain.League;
import hh.swd20.FootySite.domain.LeagueRepository;
import hh.swd20.FootySite.domain.User;
import hh.swd20.FootySite.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootySiteApplication {

	private static final Logger log = LoggerFactory.getLogger(FootySiteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FootySiteApplication.class, args);
	}

	@Bean
	public CommandLineRunner teamDemo(TeamRepository teamRepository, LeagueRepository lrepository,
			UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of teams");
			lrepository.save(new League("Bundesliga"));
			lrepository.save(new League("Premier League"));
			lrepository.save(new League("La Liga"));
			lrepository.save(new League("Seria A"));
			lrepository.save(new League("Ligue 1"));
			lrepository.save(new League("Veikkausliiga"));

			teamRepository.save(new Team("Bayern Munchen", 1900, "Manuel Neuer", "Hansi Flick", 1,
					lrepository.findByName("Bundesliga").get(0)));
			teamRepository.save(new Team("Liverpool", 1892, "Jordan Henderson", "Jurgen Klopp", 1,
					lrepository.findByName("Premier League").get(0)));
			teamRepository.save(new Team("Hjk", 1907, "Mosa", "Mika Lehkosuo", 3,
					lrepository.findByName("Veikkausliiga").get(0)));

			log.info("fetch all teams");
			for (Team team : teamRepository.findAll()) {
				log.info(team.toString());
			}

			// users admin and user, with unique hash-passwords for both of them
			User user1 = new User("user", "$2a$05$l69xjB81JWRZnvwMLBgFI.GPYSGkTC56z1Y9HCZ9YhzotAxevYtQy", "USER");
			User user2 = new User("admin", "$2a$05$rt.yiEtKh6hNh73rK3YxtOQRidQ0rp0VlcApgdY6haY9L6Ea5beEK", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			for (Team team : teamRepository.findAll()) {
				log.info(team.toString());
			}

		};
	}
}
