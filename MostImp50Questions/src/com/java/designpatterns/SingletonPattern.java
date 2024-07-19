package com.java.designpatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonPattern {

	public static void main(String[] args) {
		Singleton  s = Singleton.getInstance();
		System.out.println(s.hashCode());
		Singleton  s1 = Singleton.getInstance();
		Singleton s2 = null;
		System.out.println(s1.hashCode());
		// Breaking  by Reflection
		Constructor[] cons = Singleton.class.getDeclaredConstructors();
		try {
			for(Constructor c : cons) {
				c.setAccessible(true);
			
				s2 = (Singleton)c.newInstance();
				break;
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
	
}

class Singleton {
	
	//1. private static reference variable
	private static Singleton singleton;
	
	//2. private constructor
	private Singleton() {
	}
	
	public  static Singleton getInstance() {
		//3. synchronized double locking mechanism
		if(singleton == null) {
			synchronized(Singleton.class) {
				if(singleton == null) {
					singleton =  new Singleton();
				}
			}
		}
		return singleton;
	}
}



/** Breaking Singleton
 *  1. Reflection     -  
 *  2. Cloning
 *  3. Serialization
 *  
 *  */

