/**
 * 
 */
package Artikelverwaltung.Application;

import java.io.IOException;
import java.util.ArrayList;

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
		AArticle art = new Article("4", "4", 4, 6.0, 6.0);
		System.out.println("---------- Test ------------\n");
		ArrayList<AArticle> list = new ArrayList<AArticle>();
		
		
		list = DAO.readAll();
		listToConsole(list);	
	}
	
	public static void listToConsole(ArrayList<AArticle> list) {
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getArticleNr() + "; ");
			System.out.print(list.get(i).getName() + "; ");
			System.out.print(list.get(i).getAmount() + "; ");
			System.out.print(list.get(i).getPriceBuy() + "; ");
			System.out.print(list.get(i).getPriceSell());
			System.out.println("\n----------------------------");
		}
	
	}
}