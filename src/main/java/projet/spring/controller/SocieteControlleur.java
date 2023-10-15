package projet.spring.controller;


import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.spring.entity.Societe;

import projet.spring.service.SocieteServices;

@RestController
@RequestMapping("/soc")
@CrossOrigin
public class SocieteControlleur {
	@Autowired
	SocieteServices societeservices;
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	@PostMapping("/ajoutSociete")
	
	public Societe ajoutSociete(@RequestBody Societe s){
		 String generatedKey = generateUniqueKey(9);
		  s.setUniqueKey(generatedKey);
		return societeservices.ajoutSociete(s); 
	}
	
	private String generateUniqueKey(int length) {
		SecureRandom secureRandom = new SecureRandom();
	    byte[] randomBytes = new byte[length];
	    secureRandom.nextBytes(randomBytes);
	    return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
	}
	@GetMapping("/getSociete")
	public List<Societe> getSociete()
	{
	return societeservices.getSociete();
	
     }

@GetMapping("/getSocieteId/{id}")
public Societe getSocieteId( @PathVariable Long id)
{
	return societeservices.getSocieteId(id);
}
@DeleteMapping("/deleteSociete/{id}")
public void DeleteSociete(@PathVariable("id") Long id) {
	societeservices.deleteSociete(id);
}
@PutMapping("/updateSociete/{id}")

public Societe updateSociete( @PathVariable Long id , @RequestBody Societe s)
{
return societeservices.updateSociete(s,id);


}
	
		
}
