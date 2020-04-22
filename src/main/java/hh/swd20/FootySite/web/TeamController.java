package hh.swd20.FootySite.web;

import hh.swd20.FootySite.domain.Team;
import hh.swd20.FootySite.domain.TeamRepository;
import hh.swd20.FootySite.domain.LeagueRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamController {

	@Autowired
	private TeamRepository repository;

	@Autowired
	private LeagueRepository lrepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/teamlist", method = RequestMethod.GET)
	public String teamList(Model model) {
		model.addAttribute("teams", repository.findAll());
		return "teamlist";
	}

	// RESTful service to get all teams
	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public @ResponseBody List<Team> bookListRest() {
		return (List<Team>) repository.findAll();
	}

	// RESTful service to get a team by id
	@RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Team> findBookRest(@PathVariable("id") Long teamId) {
		return repository.findById(teamId);
	}

	@RequestMapping(value = "/add")
	public String addTeam(Model model) {
		model.addAttribute("team", new Team());
		model.addAttribute("leagues", lrepository.findAll());
		return "addteam";
	}

	@RequestMapping(value = "/edit/{id}")
	public String addTeam(@PathVariable("id") Long teamId, Model model) {
		model.addAttribute("team", repository.findById(teamId));
		model.addAttribute("leagues", lrepository.findAll());
		return "editteam";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Team team) {
		repository.save(team);
		return "redirect:teamlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTeam(@PathVariable("id") Long teamId, Model model) {
		repository.deleteById(teamId);
		return "redirect:../teamlist";
	}

}
