package hightech.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import hightech.config.HibernateUtil;

import hightech.dao.BoutiqueDao;

import hightech.model.Boutique;

@Path("/boutique")
public class BoutiqueRessource {

	
	
    
    @GET
    @Produces("application/json")
    public List<Boutique> getBoutiques() {
    	Session session = HibernateUtil.getSessionFactory().
    			openSession();
    			BoutiqueDao boutiqueDao = new BoutiqueDao(session);
        return boutiqueDao.findAll();
    }
    
}
