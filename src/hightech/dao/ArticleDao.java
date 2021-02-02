package hightech.dao;

import hightech.model.Article;
import org.hibernate.Session;


public class ArticleDao extends GenericDao <Article,Integer> {

	public ArticleDao(Session session) {
		super(Article.class, session);
		}


}
