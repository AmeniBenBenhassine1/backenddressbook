package projet.spring.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personne")
public class Personne {
	 
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	  @Column
    private String contact;
	 @Column
		private String tel;
	  @Column
			private String mobile;
		@Column
		private String fax;
		
		@Column
		private String email;
		@Column
		private String fonction;
		
		@Column
		private String responsable;
		 @JsonBackReference
		@ManyToOne
		  @JoinColumn(name = "societe_id")
		
		// Le nom de la colonne de clé étrangère dans la table "personne"
	    private Societe societe;
		
		public Personne() {
	
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getFax() {
			return fax;
		}

		public void setFax(String fax) {
			this.fax = fax;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFonction() {
			return fonction;
		}

		public void setFonction(String fonction) {
			this.fonction = fonction;
		}

		public String getResponsable() {
			return responsable;
		}

		public void setResponsable(String responsable) {
			this.responsable = responsable;
		}

		public Societe getSociete() {
			return societe;
		}

		public void setSociete(Societe societe) {
			this.societe = societe;
		}

		@Override
		public String toString() {
			return "Personne [id=" + id + ", contact=" + contact + ", tel=" + tel + ", mobile=" + mobile + ", fax="
					+ fax + ", email=" + email + ", fonction=" + fonction + ", responsable=" + responsable
					+ ", societe=" + societe + "]";
		}

		public Personne(Long id, String contact, String tel, String mobile, String fax, String email, String fonction,
				String responsable, Societe societe) {
			super();
			this.id = id;
			this.contact = contact;
			this.tel = tel;
			this.mobile = mobile;
			this.fax = fax;
			this.email = email;
			this.fonction = fonction;
			this.responsable = responsable;
			this.societe = societe;
		}

		
		  
	
}