package hightech.dao;

import org.hibernate.Session;


import hightech.model.categorieArticle;

public class CategorieArticleDao  extends GenericDao <categorieArticle,Integer>{
	
	public CategorieArticleDao(Session session) {
		super(categorieArticle.class, session);
		}


}
