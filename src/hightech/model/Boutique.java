package hightech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public final class Boutique {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "nomboutique")
	private String nomBoutique;
	
	@Column(name = "description")
	private String descrition;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "adressemail")
	private String adresseMail;
	
	@Column(name = "tel")
	private String tel;
	
	@Transient
	private static Boutique instance;
	
	private Boutique() {
		
	}

	private Boutique(String id, String nomBoutique, String descrition, String adresse, String adresseMail, String tel) {
		super();
		this.id = id;
		this.nomBoutique = nomBoutique;
		this.descrition = descrition;
		this.adresse = adresse;
		this.adresseMail = adresseMail;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomBoutique() {
		return nomBoutique;
	}

	public void setNomBoutique(String nomBoutique) {
		this.nomBoutique = nomBoutique;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	  public static Boutique getInstance(String id, String nomBoutique, String descrition, String adresse, String adresseMail, String tel) {
	        if (instance == null) {
	            instance = new Boutique(id, nomBoutique, descrition, adresse,adresseMail, tel);
	        }
	        return instance;
	    }
	
	
	
}
