package Jet;

import java.awt.Component;

/**
 * A Jet template.
 * 
 * Use this function to render any gui with ..
 *
 */
public class JetTpl {

	public static String tplName;
	
	public JetTpl(){
		
	}
	
	public JetTpl(String name) {
		JetTpl.tplName = name;
	}
	
	public Component render(TplVars vars) {
		return null;
	}
	
	
}
