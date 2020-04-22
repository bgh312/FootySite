package hh.swd20.FootySite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntController {

	@GetMapping("/international")
	public String getInternationalPage() {
		return "teamlist";
	}

}