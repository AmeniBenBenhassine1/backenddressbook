package projet.spring.service;
import java.util.List;



import projet.spring.entity.Personne;

public interface PersonneServices {
	Personne AjoutPersonne(Personne p);
	public List<Personne> getPersonnes();
    public Personne getPersonneId(Long id);
     public void    deletePersonne(Long id);
     Personne updatePersonne(Personne p,Long id);
    
     List<Personne> findBySocieteId(Long societeId);
    
     List<Personne> findBySocieteName(String societeName);
  
   
     
}
