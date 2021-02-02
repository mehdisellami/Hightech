package hightech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Entity
public class categorieArticle {
	
	@Id
	@Column(name = "libelle")
	String libelleArticle;
	
	public categorieArticle() {
		
	}

	public categorieArticle(String libelleArticle) {
		super();
		this.libelleArticle = libelleArticle;
	}

	public String getLibelleArticle() {
		return libelleArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}
	
	

}
