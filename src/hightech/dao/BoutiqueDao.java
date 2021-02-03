package hightech.dao;

import org.hibernate.Session;

import hightech.model.Boutique;

public class BoutiqueDao  extends GenericDao <Boutique,Integer>  {
	
	public BoutiqueDao(Session session) {
		super(Boutique.class, session);
		}


}
