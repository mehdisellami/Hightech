package hightech.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import hightech.dao.ArticleDao;
import hightech.dao.HightechDao;
import hightech.model.Article;

@Path("/hello")

public class HightechRessource {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    public HightechRessource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article getTodo() {
    	Article article = HightechDao.instance.getModel().get(id);
        if(article==null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return article;
    }

    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Article getTodoHTML() {
    	Article article = HightechDao.instance.getModel().get(id);
        if(article==null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return article;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putTodo(JAXBElement<Article> article) {
        Article c = article.getValue();
        return putAndGetResponse(c);
    }
    
  

    @DELETE
    public void deleteTodo() {
        Article c = HightechDao.instance.getModel().remove(id);
        if(c==null)
            throw new RuntimeException("Delete: Todo with " + id +  " not found");
    }

    private Response putAndGetResponse(Article article) {
        Response res;
        if(HightechDao.instance.getModel().containsKey(article.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        HightechDao.instance.getModel().put(article.getId(), article);
        return res;
    }


}
