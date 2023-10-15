package projet.spring.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import projet.spring.entity.Personne;
import projet.spring.entity.Societe;
import projet.spring.repository.PersonneRepository;
import projet.spring.repository.SocieteRepository;

@Service
public class SocieteServicesImp implements SocieteServices {
	@Autowired
	SocieteRepository RepSociete;
	@Autowired
	PersonneRepository RepPersonne;
	public Societe ajoutSociete (Societe s) {
		
	return	RepSociete.save(s);
		
	}
	@Override
	public List<Societe> getSociete() {
		
		return (List<Societe>) RepSociete.findAll();
	}
	@Override
	public Societe getSocieteId(Long id) {
		  Optional<Societe> optionalSoc = RepSociete.findById(id);
		    
		    if (optionalSoc.isPresent()) {
		        return optionalSoc.get();
		    } else {
		       
		        throw new EntityNotFoundException("Societe non trouvée pour l'ID : " + id);
		    }
	}
	 @Override
	    @Transactional
	    public void deleteSociete(Long id) {
	      
	        Societe societe = RepSociete.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Societe non trouvée pour l'ID : " + id));
	     
	        List<Personne> personnes = societe.getPersonnes();
	        
	      
	        for (Personne personne : personnes) {
	            RepPersonne.delete(personne);
	        }
	        
	        
	        RepSociete.delete(societe);
	    }
	@Override
	public Societe updateSociete(Societe s, Long id) {
		 Societe oldSoc = RepSociete.findById(id).orElse(null);
		    if (oldSoc== null) {
		       
		        return null; 
		    }

		 
		    System.out.println("Ancienne Societe : " + oldSoc.toString());
         
             oldSoc.setEmail(s.getEmail());
             oldSoc.setName(s.getName());
           
            oldSoc.setAdresse(s.getAdresse());
          
            oldSoc.setSite(s.getSite());
          
            oldSoc.setNumfax(s.getNumfax());
            oldSoc.setNumtlf(s.getNumtlf());
          oldSoc.setCategorie(s.getCategorie());
          oldSoc.setCodefiscal(s.getCodefiscal());
          oldSoc.setRepresentant(s.getRepresentant());
          oldSoc.setRne(s.getRne());
            
		    System.out.println("Nouvelle Societe : " + oldSoc.toString());

		    RepSociete.save(oldSoc);

		    return oldSoc;
		}
	
	
	}
	
	


