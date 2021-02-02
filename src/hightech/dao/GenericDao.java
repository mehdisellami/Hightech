package hightech.dao;

import java.util.List;

import javax.ws.rs.PathParam;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDao <T,P> {
	
	protected Session session;
	private Class<T> entity;
	
	
	public GenericDao(Class<T> entity, Session session) {
	this.session = session;
	this.entity = entity;
	}
	
	
	public Session getSession() {
	return session;
	}
	
	
	public P save(T obj) throws Exception {
	Transaction tx = null;
	P result;
			try {
			tx = session.beginTransaction();
			result = (P) session.save(obj);
			tx.commit();
			} catch (Exception e) {
			if (tx != null)
			tx.rollback();
			throw e;
					}
	return result;
	}
	
	public void update(T obj) throws Exception {
		Transaction tx = null;
			try {
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
			} catch (Exception e) {
			if (tx != null)
			tx.rollback();
			throw e;
				}
		}
	
	
		public void delete(T obj) throws Exception {
		Transaction tx = null;
				try {
				tx = session.beginTransaction();
				session.delete(obj);
				tx.commit();
				} catch (Exception e) {
				if (tx != null)
				tx.rollback();
				throw e;
				}
		}
		
		
		public T findById(String id) {
		return session.get(entity, id);
		}
		
		public List<T> findArticleByCategorie(@PathParam("categorie") String categorie) {
			return (List<T>) session.createQuery("from " + entity.getName()+" WHERE categorieArticle =:"+categorie).list();
		
			}
		
		
		
		public List<T> findAll() {
		return (List<T>) session.createQuery("from " + entity.getName()).list();
		}
		
		
		
		}
