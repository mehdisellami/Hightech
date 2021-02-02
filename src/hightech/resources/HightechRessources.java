package hightech.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.hibernate.Session;

import hightech.config.HibernateUtil;
import hightech.dao.ArticleDao;
import hightech.dao.GenericDao;
import hightech.dao.HightechDao;
import hightech.model.Article;
import hightech.model.Boutique;


@Path("/listearticle")
public class HightechRessources {

		@Context
	    UriInfo uriInfo;
	    @Context
	    Request request;
	    String id;
	    


	  
	    
	    @GET
	    @Produces( MediaType.APPLICATION_JSON )
	    public List<Article> getArticles() {
	    	Session session = HibernateUtil.getSessionFactory().
	    			openSession();
	    			ArticleDao articleDao = new ArticleDao(session);
	        return articleDao.findAll();
	    }
	    
	    @GET
	    @Path("{id}")
	    @Produces( MediaType.APPLICATION_JSON )
	    public Article getArticlesByID(@PathParam("id") String id) {
	    	Session session = HibernateUtil.getSessionFactory().
	    			openSession();
	    			ArticleDao articleDao = new ArticleDao(session);
	        return articleDao.findById(id);
	    }
	    
	    @GET
	    @Path("/articlebycategorie/{categorie}")
	    @Produces( MediaType.APPLICATION_JSON )
	    public List<Article> getArticlesByCategorie(@PathParam("categorie") String categorie) {
	    	Session session = HibernateUtil.getSessionFactory().
	    			openSession();
	    			ArticleDao articleDao = new ArticleDao(session);
	        return articleDao.findArticleByCategorie(categorie);
	    }
	    
	    
//	    @GET
//	    @Path("count")
//	    @Produces(MediaType.TEXT_PLAIN)
//	    public String getCount() {
//	        int count = HightechDao.instance.getModel().size();
//	        return String.valueOf(count);
//	    }
//	    
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Article addArticle(Article article) throws Exception {
	    	
	    	Session session = HibernateUtil.getSessionFactory().
	    			openSession(); 
	    	
	    	
	    	Article a = new Article();
	    	a.setId(article.getId());
	    	a.setLibelle(article.getLibelle());
	    	a.setMarque(article.getMarque());
	    	a.setPhoto(article.getPhoto());
	    	
	    	Boutique b1 = Boutique.getInstance("1", "Hightech Boutique", "Vente tous", "8 boulvard 77777", "boutique@nanterre.fr", "0758723711");
	    	
	    	a.setBoutiqueArticle(b1);
	    	a.setPrix(article.getPrix());
	    	a.setCategorieArticle(article.getCategorieArticle());
	    	
	    	
	    	ArticleDao x = new ArticleDao(session);
	    	x.save(a);
	    	
	    	
	    	return a;
	    	}
	    
	    @DELETE
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public String DeleteArticle(@PathParam("id") String id) throws Exception {
	    	
	    	Session session = HibernateUtil.getSessionFactory().
	    			openSession(); 
	    	
	    	ArticleDao x = new ArticleDao(session);
	    	x.delete(x.findById(id));
	    	
	    	
	    	return "Article Supprimé ! ";
	    	}
	    
	    @PUT
	    @Path("{id}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Article updateArticle(@PathParam("id") String id , Article article) throws Exception {
	    	
	    	Session session = HibernateUtil.getSessionFactory().
	    			openSession(); 
	    	
	    	ArticleDao x = new ArticleDao(session);
	    	
	    	Article a = x.findById(id);
	    	a.setLibelle(article.getLibelle());
	    	a.setMarque(article.getMarque());
	    	a.setPhoto(article.getPhoto());
	    	a.setPrix(article.getPrix());	    	

	    	x.update(a);
	
	    	return  a;
	    	}
	   


	

	    // Defines that the next path parameter after todos is
	    // treated as a parameter and passed to the TodoResources
	    // Allows to type http://localhost:8080/rest.todo/rest/todos/1
	    // 1 will be treaded as parameter todo and passed to TodoResource
//	    @Path("{article}")
//	    @Produces( MediaType.APPLICATION_JSON )
//	    public HightechRessource getArticlesByID(@PathParam("article") String id) {
//	        return new HightechRessource(uriInfo, request, id);
//	    }

	   
	    
}
