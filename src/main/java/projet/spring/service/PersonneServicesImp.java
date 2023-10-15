package projet.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import jakarta.persistence.EntityNotFoundException;
import projet.spring.entity.Personne;

import projet.spring.repository.PersonneRepository;

@Service
public class PersonneServicesImp implements PersonneServices{

	@Autowired
	PersonneRepository RepPersonne;
	
	@Override
	
	public Personne AjoutPersonne(Personne p) {
		
	return	RepPersonne.save(p);
		
	}
	@Override
	public List<Personne> getPersonnes() {
		
		return (List<Personne>) RepPersonne.findAll();
}
	@Override
	public Personne getPersonneId(Long id) {
	    Optional<Personne> optionalPers = RepPersonne.findById(id);
	    
	    if (optionalPers.isPresent()) {
	        return optionalPers.get();
	    } else {
	       
	        throw new EntityNotFoundException("Personne non trouvée pour l'ID : " + id);
	    }
	}

	@Override
	public void deletePersonne(Long id) {
		
		RepPersonne.deleteById(id);
	}
	@Override
	public Personne updatePersonne(Personne p, Long id) {
	    Personne oldPers = RepPersonne.findById(id).orElse(null);
	    if (oldPers == null) {
	       
	        return null; 
	    }

	 
	    System.out.println("Ancienne personne : " + oldPers.toString());
	    
	    oldPers.setContact(p.getContact());
	    oldPers.setEmail(p.getEmail());
	    oldPers.setFax(p.getFax());
	    oldPers.setMobile(p.getMobile());
	    oldPers.setTel(p.getTel());
	    oldPers.setFonction(p.getFonction());
	    oldPers.setResponsable(p.getResponsable());
	 
	    System.out.println("Nouvelle personne : " + oldPers.toString());

	    RepPersonne.save(oldPers);

	    return oldPers;
	}
	
	@Override
	public List<Personne> findBySocieteId(Long societeId) {
	    return RepPersonne.findBySocieteId(societeId);
	}
	@Override
	public List<Personne> findBySocieteName(String societeName) {
		  return RepPersonne.findBySocieteName(societeName);
	}
	


	}




	












