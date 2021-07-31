package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SonucController {
/*
	@RequestMapping("submit")
	public String islemYap(HttpServletRequest req) {
		int s1 = Integer.parseInt(req.getParameter("sayi1"));
		int s2 = Integer.parseInt(req.getParameter("sayi2"));
		int sum =s1+s2;
		int product =s1*s2;
		
		HttpSession session = req.getSession();
		session.setAttribute("totalOfNumbers", sum);
		session.setAttribute("productOfNumbers", product);
		
		return "sonuc";}
*/
	@RequestMapping("submit")
	public String islemYap(@RequestParam("sayi1") int s1,@RequestParam("sayi2") int s2, Model m ) {
		
		int sum = s1+s2;
		int product= s1/s2;
		m.addAttribute("totalOfNumbers",sum );
		m.addAttribute("productOfNumbers",product );
		return "sonuc";
		
	}
	

}