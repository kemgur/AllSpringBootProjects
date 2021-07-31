package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@RequestMapping("/") //its meaning: My home page
	public String home() {
		return "index";
	}
	
}
 