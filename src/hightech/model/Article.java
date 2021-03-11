package hightech.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity
public class Article {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "libelle")
	private String libelle;
	
	@Column(name = "Marque")
	private String Marque;
	
	@Column(name = "Prix")
	private double Prix;
	
	
	//private CategorieArticle categorieArticle;
	@Column(name = "Photo")
	private String Photo;
	

	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "boutique")
	private Boutique boutiqueArticle;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name = "categorie")
	private categorieArticle categorieArticle;
	
	public Article() {
		
	}




	public Article(String id, String libelle, String marque, double prix, String photo, Boutique boutiqueArticle,
			hightech.model.categorieArticle categorieArticle) {
		super();
		this.id = id;
		this.libelle = libelle;
		Marque = marque;
		Prix = prix;
		Photo = photo;
		this.boutiqueArticle = boutiqueArticle;
		this.categorieArticle = categorieArticle;
	}






	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}






	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getMarque() {
		return Marque;
	}

	public void setMarque(String marque) {
		Marque = marque;
	}

	public double getPrix() {
		return Prix;
	}

	public void setPrix(double prix) {
		Prix = prix;
	}




	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}



	public Boutique getBoutiqueArticle() {
		return boutiqueArticle;
	}


	public void setBoutiqueArticle(Boutique boutiqueArticle) {
		this.boutiqueArticle = boutiqueArticle;
	}






	public categorieArticle getCategorieArticle() {
		return categorieArticle;
	}






	public void setCategorieArticle(categorieArticle categorieArticle) {
		this.categorieArticle = categorieArticle;
	}





	
	
	
	
	
	

}
