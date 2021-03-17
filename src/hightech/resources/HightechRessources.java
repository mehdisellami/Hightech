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
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("/articlebycategorie/{categorie}")

	    @Produces( MediaType.APPLICATION_JSON )
	    public List<Article> getArticlesByCategorie(@PathParam("categorie") String categorie) {
	    	Session session = HibernateUtil.getSessionFactory().
	    			openSession();
	    			ArticleDao articleDao = new ArticleDao(session);
	        return articleDao.findArticleByCategorie(categorie);
	    }
	    
	    
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response addArticle(Article article) throws Exception {
	    	
	    	Session session = HibernateUtil.getSessionFactory().
	    			openSession(); 
	    	
	    	
	    	Article a = new Article();
	    	a.setId(article.getId());
	    	a.setLibelle(article.getLibelle());
	    	a.setMarque(article.getMarque());
	    	a.setPhoto(article.getPhoto());
	    	a.setCategorieArticle(article.getCategorieArticle());

	    	Boutique b1 = Boutique.getInstance("1", "Hightech Boutique", "Vente tous", "8 boulvard 77777", "boutique@nanterre.fr", "0758723711");
	    	
	    	a.setBoutiqueArticle(b1);
	    	a.setPrix(article.getPrix());
	    	
	    	
	    	ArticleDao x = new ArticleDao(session);
	    	x.save(a);
	    	
	    	
	    	 return Response.ok()
	                .entity(article)
	                .header("Access-Control-Allow-Origin", "*")
	                .build();
	    	}
	    
	    @DELETE
	    @Path("{id}")
	    public boolean DeleteArticle(@PathParam("id") String id) throws Exception {
	    	
	    	Session session = HibernateUtil.getSessionFactory().
	    			openSession(); 
	    	
	    	ArticleDao x = new ArticleDao(session);
	    	
	    	Article s = x.findById(id);
	    	System.out.println(s);
	    	x.delete(s);
	    	
	    	
	    	return true;
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
	   


	


	   
	    
}
