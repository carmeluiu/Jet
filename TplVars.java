package Jet;

import java.util.HashMap;

public class TplVars extends HashMap<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString(){
		String res = "";
		for(String name: keySet()){
			
			res += "[" + name + "] => Object\n";
			res += "   " + get(name).toString() + "\n";
		}
		return res;
	}
}
