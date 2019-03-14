/**
 * 
 */
package Artikelverwaltung.Modell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author nils743
 *
 */
public class DAO {

	// Attributes
	private static final String dbName = "./Artikelverwaltung/Modell/ArticleList.txt";
	private static final File file = new File(dbName);
	private static final String delimiter= "\n";
	
	// Getter & Setter
	
	/**
	 * create a dataset
	 * @throws IOException 
	 */
	public static void create(AArticle article) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		fw.write(delimiter + article.toString());
		fw.close();
	}
	
	/**
	 * 
	 * @param inputList
	 * @throws IOException
	 */
	public static void createAll(ArrayList<AArticle> inputList) throws IOException {
		FileWriter fw = new FileWriter(file, false);
		for (AArticle aArticle : inputList) {
			fw.write(delimiter + aArticle.toString());
		}
		fw.close();
	}
	
	
	/**
	 * reads one dataset
	 * @param articleNr
	 * @throws IOException 
	 * 
	 */
	public static Article read(String articleNr) throws IOException {
		
		// Article element = new Article();
		ArrayList<AArticle> list = new ArrayList<AArticle>();
		list = DAO.readAll();
		for (AArticle aArticle : list) {
			if(aArticle.getArticleNr().equals(articleNr)) {
				return (Article) aArticle;
			}
		}
		return null;
	}
	
	/**
	 * read all datasets
	 * @throws IOException 
	 * 
	 */
	public static ArrayList<AArticle> readAll() throws IOException {
		
		ArrayList<AArticle> list = new ArrayList<AArticle>();
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter(delimiter);
		
		while(scanner.hasNext()) {
			String info[] = scanner.next().split("-");
			list.add(new Article(info[0], info[1], Integer.valueOf(info[2]), Double.valueOf(info[3]), Double.valueOf(info[4])));
		}
		scanner.close();
		
		return list;
	}
	
	/**
	 * updates one dataset
	 * @throws IOException 
	 * 
	 */
	public static boolean update(String articleNr, AArticle newArticle) throws IOException {
		
		ArrayList<AArticle> list = new ArrayList<AArticle>();
		
		list = DAO.readAll();
		for (AArticle aArticle : list) {
			if(aArticle.getArticleNr().equals(newArticle.getArticleNr())) {
				System.out.println("Gewählte Artikelnummer ist bereits vorhanden!");
				return false;
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getArticleNr().equals(articleNr)) {
				list.remove(i);
				list.add(i, newArticle);
				break;
			}
		} // end for
			 
		DAO.createAll(list);
		return true;
	}
		
	
	/**
	 * deletes one dataset
	 * @throws IOException 
	 *
	 */
	public static boolean delete(String articleNr) throws IOException {
		
		ArrayList<AArticle> list = new ArrayList<AArticle>();
		list = DAO.readAll();
		
		for (AArticle aArticle : list) {
			if(aArticle.getArticleNr().equals(articleNr)) {
				System.out.println("Gewählte Artikelnummer ist vorhanden!");
				list.remove(aArticle);
				DAO.createAll(list);
				return true;
			}
		}
		
		System.out.println("Diese Artikelnummer ist nicht vergeben!");
		return false;
	}
}
