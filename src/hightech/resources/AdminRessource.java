package hightech.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import hightech.config.HibernateUtil;
import hightech.dao.AdminDao;
import hightech.dao.ArticleDao;
import hightech.dao.BoutiqueDao;
import hightech.model.Admin;
import hightech.model.Boutique;

@Path("/loginAdmin")
public class AdminRessource {
	
	
	
	
    
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public List<Admin> getBoutiques() {
    	Session session = HibernateUtil.getSessionFactory().
    			openSession();
    			AdminDao adminDao = new AdminDao(session);
        return adminDao.findAll();
    }
    
	
	
	@Path("/Login/{username}/{password}")
	@Produces( MediaType.APPLICATION_JSON )
	@GET
	public String loginUser(@PathParam("username") String username, @PathParam("password") String password) {
		
		Session session = HibernateUtil.getSessionFactory().
    			openSession();
    			AdminDao adminDao = new AdminDao(session);
		
		
    		adminDao.finduserByuserNameandPassword(username , password);
		 return String.format("L'utilisateur %s est Connecté", username);
			
}

}
