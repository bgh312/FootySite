package hh.swd20.FootySite.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class League {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long leagueid;
	private String name;

	@OneToMany
	private List<Team> teams;

	public League() {
	}

	public League(String name) {
		super();
		this.name = name;
	}

	public Long getLeagueid() {
		return leagueid;
	}

	public void setLeagueid(Long leagueid) {
		this.leagueid = leagueid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "League [leagueid=" + leagueid + ", name=" + name + "]";
	}
}
