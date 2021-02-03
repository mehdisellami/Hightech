package hightech.dao;

import hightech.model.Article;

import java.util.List;

import javax.ws.rs.PathParam;


import org.hibernate.Session;


public class ArticleDao extends GenericDao <Article,Integer> {

	public ArticleDao(Session session) {
		super(Article.class, session);
		}

	public List<Article> findArticleByCategorie(@PathParam("categorie") String categorie) {
		return (List<Article>) session.createQuery("from Article a WHERE a.categorieArticle =:"+categorie).list();
	
		}

}
