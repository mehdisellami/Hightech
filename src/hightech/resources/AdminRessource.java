package hightech.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    
	
	
	@Path("/Login")
	@Produces( MediaType.APPLICATION_JSON )
	@POST
	public List<Admin> loginUser(Admin admin)  throws Exception {
		boolean rtr=false;
		Session session = HibernateUtil.getSessionFactory().
    			openSession();
    			AdminDao adminDao = new AdminDao(session);
		
    			if (adminDao.finduserByuserNameandPassword(admin).isEmpty()) {
    			 throw new Exception("Sorry username or password dos not existe");
    			}
    			else 
    			{    	return	 adminDao.finduserByuserNameandPassword(admin); 
    			
    			 
    			}
    			}

}
