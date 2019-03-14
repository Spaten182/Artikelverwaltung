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
	private static String dbName = "./Artikelverwaltung/Modell/ArticleList.txt";
	private static File file = new File(dbName);
	private static String delimiter= "\n";
	
	// Getter & Setter
	
	/**
	 * create dataset
	 * @throws IOException 
	 */
	public static void create(AArticle article) throws IOException {
		FileWriter fw = new FileWriter(file, true);
		fw.write(delimiter + article.toString());
		fw.close();
	}
	
	/**
	 * read dataset
	 * @param articleNr XXX
	 * @throws IOException 
	 * 
	 */
	public static void read() throws IOException {
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter(delimiter);
		String currentLine = scanner.next();
		scanner.close();
		System.out.println(currentLine);
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
			
			// TODO
			list.add(new Article(info[0], info[1], Integer.valueOf(info[2]), Double.valueOf(info[3]), Double.valueOf(info[4])));
		}
		scanner.close();
		
		return list;
	}
	
	/**
	 * update dataset
	 * 
	 */
	public static void update() {
		
	}
		
	
	/**
	 * delete dataset
	 *
	 */
	public static void delete() {
		
		// list.remove(index)
		
	}
}
