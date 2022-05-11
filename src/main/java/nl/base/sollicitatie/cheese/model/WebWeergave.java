package nl.base.sollicitatie.cheese.model;

public interface WebWeergave {
	
	/**
	 * Title for on the web
	 * @return
	 */
	public String getTitle();
	
	public double getPrice();
	
	/**
	 * De hoeveelheid porties die beschikbaar zijn.
	 * @return
	 */
	public int getAvailablePortions();
	
}
