package hightech.dao;

import hightech.model.Article;

import java.util.List;

import javax.ws.rs.PathParam;


import org.hibernate.Session;


public class ArticleDao extends GenericDao <Article,Integer> {

	public ArticleDao(Session session) {
		super(Article.class, session);
		}

	
	public List<Article> findArticleByCategorie(@PathParam("pram") String pram) {
	
		return (List<Article>) session.createQuery("from Article WHERE categorie ='" +pram+"' ").list();
	
		}

}
