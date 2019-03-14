/**
 * 
 */
package Artikelverwaltung.Application;

import java.io.IOException;

import Artikelverwaltung.Modell.*;

/**
 * @author nils743
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		AArticle art = new Article("1", "2", 3, 4.0, 5.0);
		System.out.println("Test");
		DAO.readAll();
	}

}
