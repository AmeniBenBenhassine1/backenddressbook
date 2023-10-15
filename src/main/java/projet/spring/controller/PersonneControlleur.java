 package projet.spring.controller;
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import projet.spring.entity.Personne;

import projet.spring.service.PersonneServices;


@RestController
@CrossOrigin
@RequestMapping("/pers")
public class PersonneControlleur {
	
	 @Autowired
private	PersonneServices personneservices;
	
	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	
	@PostMapping("/AjouterPersonne")

	public Personne AjoutPersonne(@RequestBody Personne p ){
	
		return personneservices.AjoutPersonne(p); 
	}
	
	
	
	@GetMapping("/getPersonnes")
	public List<Personne> getPersonnes()
	{
	return personneservices.getPersonnes();
	
     }
	

@GetMapping("/getPersonneId/{id}")
public Personne getPersonneId( @PathVariable Long id)
{
	return personneservices.getPersonneId(id);
}
@DeleteMapping("/deletePersonne/{id}")
public void DeletePersonne(@PathVariable("id") Long id) {
	personneservices.deletePersonne(id);
}
@PutMapping("/updatePersonne/{id}")

public Personne updatePersonne( @PathVariable Long id , @RequestBody Personne p)
{
return personneservices.updatePersonne(p ,id);


}
@GetMapping("/societe/{societeId}")
public ResponseEntity<List<Personne>> getPersonnesBySociete(@PathVariable Long societeId) {
    List<Personne> personnes = personneservices.findBySocieteId(societeId);
    return ResponseEntity.ok(personnes);
}
@GetMapping("/societe/nom/{societeName}")
public ResponseEntity<List<Personne>> getPersonnesBySocieteName(@PathVariable("societeName") String societeName) {
    List<Personne> personnes = personneservices.findBySocieteName(societeName);
    return ResponseEntity.ok(personnes);
}



}
