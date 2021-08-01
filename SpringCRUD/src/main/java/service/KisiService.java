package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Kisi;
import repository.KisiRepository;

@Service
public class KisiService {

	public static KisiRepository kisiRepository;//constructor
	
	//Dependency Injection
	@Autowired
	public KisiService(KisiRepository kisiRepository) {
		this.kisiRepository = kisiRepository;
	}
	
	public List<Kisi> tumKisileriGetir(){
		return kisiRepository.findAll();
	}
}
