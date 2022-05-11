package nl.base.sollicitatie;

import java.util.ArrayList;
import java.util.List;

import nl.base.sollicitatie.cheese.Entity;
import nl.base.sollicitatie.cheese.entities.*;
import nl.base.sollicitatie.cheese.model.Cheese;
import nl.base.sollicitatie.cheese.model.HasWebrep;
import nl.base.sollicitatie.cheese.model.Sausage;
import nl.base.sollicitatie.cheese.model.WebWeergave;

/**
 * The most amazing webapp ever to taste cheese (actual web implementation pending)
 *
 * This represents the web facing part of the cheese tasting app
 *
 */
public class App {
	private static final Log log = new Log(App.class);
	private static final List<Class<? extends Cheese>> registeredCheeses = new ArrayList<Class<? extends Cheese>>();
	private static final List<Class<? extends Sausage>> registeredSausages = new ArrayList<>();

	static {
		register(Cheddar.class);
		register(Parmesan.class);
		register(Gouda.class);
		register(Manchego.class);
		register(Emmentaler.class);
		registerSausage(Bratwurst.class);
		registerSausage(Frankfurters.class);
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		App app = new App();

		System.out.println("--- init -- ");
		app.fillDb();
		System.out.println("--- main page -- ");
		app.showMain();
		System.out.println("--- cheese page -- ");
		app.clickEetCheese();
		System.out.println("--- back to main -- ");
		app.showMain();
		System.out.println("--- done -- ");


	}

	private void clickEetCheese() {
		//Assume the user clicked the first gouda
		Entity cheese= new Gouda().load(1);
		System.out.println("You selected: " + ((HasWebrep) cheese).getWeb().getTitle() );
		System.out.println("Eat this cheese? (Y/n)?");
		//Assume the user chose Yes
		System.out.println("\n You chose to eat the cheese, we hope you enjoyed the experience");
		((Cheese) cheese).eatCheese();
		cheese.save();

	}

	private void clickEatSausage() {
		//Assume the user clicked the first Frankfurters
		Entity sausage= new Frankfurters().load(1);
		System.out.println("You selected: " + ((HasWebrep) sausage).getWeb().getTitle() );
		System.out.println("Eat this sausage? (Y/n)?");
		//Assume the user chose Yes
		System.out.println("\n You chose to eat the sausage, we hope you enjoyed the experience");
		((Sausage) sausage).eatSausage();
		sausage.save();
	}

	private void fillDb() {
		new Gouda().save();
		new Gouda().save();
		new Parmesan().save();
		new Cheddar().save();
		new Manchego().save();
		new Emmentaler().save();
		new Frankfurters().save();
		new Bratwurst().save();
		Manchego partial = new Manchego();
		partial.eatCheese();
		partial.eatCheese();
		partial.eatCheese();
		partial.eatCheese();
		partial.save();

		Frankfurters partial1 = new Frankfurters();
		partial1.eatSausage();
		partial1.eatSausage();
		partial1.eatSausage();
		partial1.eatSausage();
		partial1.save();

	}

	private void showMain() throws InstantiationException, IllegalAccessException {
		List<Cheese> cheeses = new ArrayList<Cheese>();
		List<Sausage> sausages = new ArrayList<>();
		for (Class<? extends Cheese> class1 : registeredCheeses) {
			Cheese prototype = class1.newInstance();
			 cheeses.addAll(Entity.findAll(class1));
		}

		for (Class<? extends Sausage> class2: registeredSausages) {
			Sausage prototype = class2.newInstance();
			sausages.addAll(Entity.findAllSausage(class2));
		}
		System.out.println(" Welcome to the magnificient cheese and sausage tasting web");
		System.out.println(" Taste all of the cheeses and sausages of the world*1");
		System.out.println("\n *1: only supported ccheese available)");

		System.out.println(" The following cheese is in stock:");
		for (Cheese cheese : cheeses) {
			if (cheese instanceof HasWebrep) {
				WebWeergave w = ((HasWebrep) cheese).getWeb();
				System.out.println("Try our: " + w.getTitle() + " there are only " + w.getAvailablePortions() + " Portions left! just: $" + w.getPrice() + " a portion");
			} else {
				log.warn("unwebified cheese!");
			}
		}

		System.out.println(" The following sausage is in stock:");
		for (Sausage sausage : sausages) {
			if (sausage instanceof HasWebrep) {
				WebWeergave w = ((HasWebrep) sausage).getWeb();
				System.out.println("Try our: " + w.getTitle() + " there are only " + w.getAvailablePortions() + " Portions left! just: $" + w.getPrice() + " a portion");
			} else {
				log.warn("unwebified sausage!");
			}
		}
	}

	private static void register(Class<? extends Cheese> class1) {
		registeredCheeses.add(class1);
	}

	private static void registerSausage(Class<? extends Sausage> class1) {
		registeredSausages.add(class1);
	}
}
