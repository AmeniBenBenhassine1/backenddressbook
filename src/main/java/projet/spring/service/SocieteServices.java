package projet.spring.service;


import java.util.List;


import projet.spring.entity.Societe;

public interface SocieteServices {
	Societe ajoutSociete(Societe s);
	public List<Societe> getSociete();
    public Societe getSocieteId(Long id);
     public void    deleteSociete(Long id);
     public Societe updateSociete(Societe s,Long id);
    
     

	
}
