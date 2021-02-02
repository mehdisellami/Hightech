package hightech.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hightech.model.Article;
import hightech.model.Boutique;
import hightech.model.Categorie;

public enum HightechDao {
	
	instance;
	
	 private Map<String, Article> contentProvider = new HashMap<>();
	
	private HightechDao() {
//		List <String> catlist = Arrays.asList("Pc Portable");
//		CategorieArticle catArticle = new CategorieArticle();
//		catArticle.setCatArticle(catlist);
		Boutique boutique = Boutique.getInstance("1","Hightech Boutique","Boutique de Vente", "1 rue bernard ", "boutique@nanterre.fr", "0758723711");
		
//		Article a1 = new Article("1","ROG Gamer", "Asus", 1500,Categorie.Pc_Portable ,"Photo.png",boutique);
//		
//		contentProvider.put("1", a1);
//		Article a2 = new Article("2","Omen Gamer", "HP", 700, Categorie.Pc_Portable , "Photo.png",boutique);
//		contentProvider.put("2", a2);
//				

	}
	
	public Map<String, Article> getModel(){
        return contentProvider;
    }

}
