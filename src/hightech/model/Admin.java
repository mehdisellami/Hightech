package hightech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Admin {
    
    @Id
    @Column(name = "id")
    private String idprivate;
    
    @Column(name = "nomadmin")
    private String nomAdmin;
    
    @Column(name = "prenomadmin")
    private String prenomAdmin;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    
    
    
    public Admin() {
		// TODO Auto-generated constructor stub
	}






	public Admin(String idprivate, String nomAdmin, String prenomAdmin, String password){
        this.idprivate =idprivate;
        this.nomAdmin=nomAdmin;
        this.prenomAdmin=prenomAdmin;
        this.password=password;
    }






	public String getIdprivate() {
		return idprivate;
	}






	public void setIdprivate(String idprivate) {
		this.idprivate = idprivate;
	}






	public String getNomAdmin() {
		return nomAdmin;
	}






	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}






	public String getPrenomAdmin() {
		return prenomAdmin;
	}






	public void setPrenomAdmin(String prenomAdmin) {
		this.prenomAdmin = prenomAdmin;
	}






	public String getUsername() {
		return username;
	}






	public void setUsername(String username) {
		this.username = username;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}







    
}
  