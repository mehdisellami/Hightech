package hightech.dao;

import java.util.List;

import javax.ws.rs.PathParam;

import org.hibernate.Session;

import hightech.model.Admin;
import hightech.model.Article;

public class AdminDao extends GenericDao <Admin,Integer> {
	
	public AdminDao(Session session) {
		super(Admin.class, session);
		}

	public<T> List<T> finduserByuserNameandPassword(Admin admin) {
		boolean rtr=false;
		
		return	 (List<T>) session.createQuery("from Admin WHERE username ='" +admin.getUsername()+"'  AND password = '"+admin.getPassword()+"' ").list();
		
		
		
		
	}


}
