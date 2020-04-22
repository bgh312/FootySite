package hh.swd20.FootySite.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<League, Long> {
	 List<League> findByName(String name);
	
}