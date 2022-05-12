package nl.base.sollicitatie.cheese.model;

public interface WebWeergave {
	/**
	 * Title for on the web
	 * @return
	 */
	String getTitle();
	double getPrice();
	/**
	 * De hoeveelheid porties die beschikbaar zijn.
	 * @return
	 */
	int getAvailablePortions();
}
