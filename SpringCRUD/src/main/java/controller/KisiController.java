package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Kisi;
import service.KisiService;

@RestController
public class KisiController {

	public KisiService kisiService;
	
	@Autowired
	public KisiController(KisiService kisiService) {
		this.kisiService =kisiService; 
	}
	
	@GetMapping(path="/kisiler")
	public List <Kisi> kisileriGetir() {
		return kisiService.tumKisileriGetir();
	}
	
}
