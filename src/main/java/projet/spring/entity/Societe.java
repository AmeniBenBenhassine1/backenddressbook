package projet.spring.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "societe")
public class Societe {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String name;
	@Column
    private String mobile;
	
	@Column
    private String numtlf;
	@Column
    private String numfax;
	@Column
    private String email;
	@Column
	private String site;
	@Column
    private String adresse;
	@Column
    private String categorie;
	@Column
    private String codefiscal;
	@Column
    private String rne;
	@Column
    private String representant;
	@Column
	private String UniqueKey;
	
	
	
	

	@JsonManagedReference
	@OneToMany(mappedBy = "societe", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Personne> personnes;
	 
	public Societe() {

    }

	public Societe(Long id, String name, String mobile, String numtlf, String numfax, String email, String site,
			String adresse, String categorie, String codefiscal, String rne, String representant, String uniqueKey,
			List<Personne> personnes) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.numtlf = numtlf;
		this.numfax = numfax;
		this.email = email;
		this.site = site;
		this.adresse = adresse;
		this.categorie = categorie;
		this.codefiscal = codefiscal;
		this.rne = rne;
		this.representant = representant;
		UniqueKey = uniqueKey;
		this.personnes = personnes;
	}

	@Override
	public String toString() {
	    return "Societe [id=" + id + ", name=" + name + ", mobile=" + mobile + ", numtlf=" + numtlf + ", numfax="
	            + numfax + ", email=" + email + ", site=" + site + ", adresse=" + adresse + ", categorie=" + categorie
	            + ", codefiscal=" + codefiscal + ", rne=" + rne + ", representant=" + representant + ", UniqueKey="
	            + UniqueKey + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNumtlf() {
		return numtlf;
	}

	public void setNumtlf(String numtlf) {
		this.numtlf = numtlf;
	}

	public String getNumfax() {
		return numfax;
	}

	public void setNumfax(String numfax) {
		this.numfax = numfax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getCodefiscal() {
		return codefiscal;
	}

	public void setCodefiscal(String codefiscal) {
		this.codefiscal = codefiscal;
	}

	public String getRne() {
		return rne;
	}

	public void setRne(String rne) {
		this.rne = rne;
	}

	public String getRepresentant() {
		return representant;
	}

	public void setRepresentant(String representant) {
		this.representant = representant;
	}

	public String getUniqueKey() {
		return UniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		UniqueKey = uniqueKey;
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}

	
	
	
	
	





    
}
