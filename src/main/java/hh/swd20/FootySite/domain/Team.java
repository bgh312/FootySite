package hh.swd20.FootySite.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int founded;
	private String captain;
	private String manager;
	private int standing;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "leagueid")
	private League league;

	public Team() {
	}

	public Team(String name, int founded, String captain, String manager, int standing, League league) {
		this.name = name;
		this.founded = founded;
		this.captain = captain;
		this.manager = manager;
		this.standing = standing;
		this.league = league;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFounded() {
		return founded;
	}

	public void setFounded(int founded) {
		this.founded = founded;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public int getStanding() {
		return standing;
	}

	public void setStanding(int standing) {
		this.standing = standing;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	@Override
	public String toString() {
		if (this.league != null)
			return "League [id=" + id + ", name=" + name + ", founded=" + founded + ", captain=" + captain
					+ ", manager=" + manager + ", standing=" + standing + " league =" + this.getLeague() + "]";
		else
			return "League [id=" + id + ", name=" + name + ", founded=" + founded + ", captain=" + captain
					+ ", manager=" + manager + ", standing=" + standing + "]";
	}

}
