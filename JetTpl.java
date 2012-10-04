package Jet;

import java.awt.Component;

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
