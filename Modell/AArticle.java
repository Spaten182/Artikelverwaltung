/**
 * 
 */
package Artikelverwaltung.Modell;

/**
 * @author nils743
 *
 */
public abstract class AArticle {
	
	// Attributes
	private String articleNr;
	private String name;
	private int amount;
	private double priceBuy;
	private double priceSell;
	
	// default Constructor
	AArticle() {
		
	}
	
	// full Constructor
	public AArticle(String articleNr, String name, int amount, double priceBuy, double priceSell) {
		this.articleNr = articleNr;
		this.name = name;
		this.amount = amount;
		this.priceBuy = priceBuy;
		this.priceSell = priceSell;
	}

	// Getter & Setter
	
	/**
	 * getArticlenr
	 * @return articleNr
	 */
	public String getArticleNr() {
		return articleNr;
	}

	/**
	 * set articleNr
	 */
	public void setArticleNr(String articleNr) {
		this.articleNr = articleNr;
	}

	/**
	 * get name of an article
	 * @return name of an article
	 */
	public String getName() {
		return name;
	}

	/**
	 * set name of an article
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get amount of an article in storage
	 * @return amount in storage
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * set amount of an article in storage
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * get price to buy this article
	 * @return price to buy this article
	 */
	public double getPriceBuy() {
		return priceBuy;
	}

	/**
	 * set price for buying this article
	 */
	public void setPriceBuy(double priceBuy) {
		this.priceBuy = priceBuy;
	}

	/**
	 * get price for which you can sell the article
	 * @return price for which you can sell the article
	 */
	public double getPriceSell() {
		return priceSell;
	}

	/**
	 * set price for which you can sell the article
	 */
	public void setPriceSell(double priceSell) {
		this.priceSell = priceSell;
	}

	@Override
	public String toString() {
		return (articleNr + "-" + name + "-" + amount + "-" + priceBuy + "-" + priceSell);
	}
}
