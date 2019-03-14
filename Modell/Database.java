/**
 * 
 */
package Artikelverwaltung.Modell;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author all
 *
 */
public class Database {
	
	// Attributes
	private ArrayList<AArticle> articleList;
	
	
	/**
	 * get the current articleList from DB
	 * @return list of all articles
	 * @throws IOException 
	 */
	public ArrayList<AArticle> getArticleList() throws IOException {
		ArrayList<AArticle> list = new ArrayList<AArticle>();
		DAO.readAll();
		return list;
	}

	/**
	 * 
	 * @param articleNr
	 * @return article
	 * @throws IOException 
	 */
	public AArticle getArticle(String articleNr) throws IOException {
		this.articleList = DAO.readAll();
		
		for (AArticle aArticle : articleList) {
			if(aArticle.getArticleNr().equals(articleNr)) {
				return aArticle;
			}
		}
		System.out.println("Artikel nicht vorhanden!");
		return null;
	}
	
	/**
	 * adds article to List
	 * @throws IOException 
	 */
	public void addArticle(AArticle newArticle) throws IOException {
		DAO.create(newArticle);
		this.articleList = DAO.readAll();
	}
	
	/**
	 * Updates an article in the db and list
	 * @param articleNr
	 * @throws IOException
	 */
	public void updateArticle(String articleNr, AArticle newArticle) throws IOException {
		DAO.update(articleNr, newArticle);
		this.articleList = DAO.readAll();
	}
	
	/**
	 * deletes article from list
	 * @param articleNr
	 * @throws IOException
	 */
	public void deleteArticle(String articleNr) throws IOException {
		DAO.delete(articleNr);
		this.articleList = DAO.readAll();
		// TODO Ausgaben in DAO oder hier? 
	}
	
	
	
	
}
 