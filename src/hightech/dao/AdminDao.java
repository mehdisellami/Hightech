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

	public boolean finduserByuserNameandPassword(@PathParam("username") String username, @PathParam("password") String password) {
		boolean rtr=false;
		
		session.createQuery("from Admin WHERE username ='" +username+"'  AND password = '"+password+"' ");
		
		return true;
		
		
	}


}
