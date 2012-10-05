package Jet;

import java.awt.Component;

/**
 * A Jet template.
 * 
 * Use this function to render any gui with ..
 *
 */
public class JetTpl {

//	public static String tplName;
	
	protected  String name;
	
	public JetTpl(){
		
	}
	
	public JetTpl(String name) {
//		JetTpl.tplName = name;
		this.name = name;
	}
	
	public Component render(TplVars vars) {
		return null;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
