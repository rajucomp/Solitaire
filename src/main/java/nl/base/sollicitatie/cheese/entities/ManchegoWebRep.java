package nl.base.sollicitatie.cheese.entities;

import nl.base.sollicitatie.cheese.model.WebWeergave;

public class ManchegoWebRep implements WebWeergave {

	private Manchego manchego;

	public ManchegoWebRep(Manchego manchego) {
		this.manchego = manchego;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Manchego!!";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 25.12d;
	}

	@Override
	public int getAvailablePortions() {
		// TODO Auto-generated method stub
		return manchego.getPortions();
	}

}
