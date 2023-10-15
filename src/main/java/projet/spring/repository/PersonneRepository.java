package projet.spring.repository;





import java.util.List;

import org.springframework.data.repository.CrudRepository;

import projet.spring.entity.Personne;


public interface PersonneRepository extends CrudRepository<Personne,Long>{

	List<Personne> findBySocieteId(Long societeId);
   
	List<Personne> findBySocieteName(String SocieteName);
	   
  
   
}
