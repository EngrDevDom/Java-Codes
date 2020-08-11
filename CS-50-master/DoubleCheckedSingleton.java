package com.doubble.checked.singleton;

/**
 * Double Checked Singleton  
 * @author sada
 *
 */
public class DoubleCheckedSingleton {
	
	public static void main(String[] args) {
		MySingleton instnace = MySingleton.getInstance();
		System.out.println(" "+instnace.hashCode());
		
		instnace =  MySingleton.getInstance();
		System.out.println(" "+instnace.hashCode());
	}

}

class MySingleton {

	private static volatile MySingleton instance;

	private MySingleton() {
		// TODO Auto-generated constructor stub
	}

	//double locking check
	public static MySingleton getInstance(){
		if(instance==null) // 1st locking check without threading
			synchronized (MySingleton.class) {
				if(instance==null)  // 2nd locking check with threading
					instance = new MySingleton();
			}
		return instance;
	}
}
