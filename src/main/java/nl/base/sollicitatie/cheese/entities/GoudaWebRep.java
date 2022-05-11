package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.model.WebWeergave;

public class GoudaWebRep implements WebWeergave {
	
	private Gouda gouda;

	public GoudaWebRep(Gouda gouda) {
		this.gouda = gouda;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Gouda, cheesy dutch goodness";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 12.50d;
	}

	@Override
	public int getAvailablePortions() {
		// TODO Auto-generated method stub
		return (int) gouda.get("portions");
	}

}
