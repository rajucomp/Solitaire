package nl.base.sollicitatie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nl.base.sollicitatie.cheese.entities.Gouda;

/**
 * 
 * assume this is a log framework
 * (not part of the assignment)
 * @author goddijn
 *
 */
public class Log {
	
	private Class<?> clazz;
	
	private static List<Class<?>> info = new ArrayList<Class<?>>(){{add(Gouda.class);}};

	public Log(Class<?> c) {
		this.clazz = c;
	}
	
	public void info(String message) {
		if (info.contains(clazz)) {
			System.out.println(message);
		}
		
	}

	public void warn(String string) {
		System.err.println(string);
		
	}

}
