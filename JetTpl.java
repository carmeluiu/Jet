package Jet;

import java.awt.Component;

/**
 * A Jet template.
 * 
 * Use this function to render any gui with ..
 *
 * Add static String with your template's name.
 * Add super(name) in you constructor .
 * Override {@link #render(TplVars)}
 */
public class JetTpl {

//	public static String tplName;
	
	protected  String name;
	
	/**
	 * 
	 */
	public JetTpl(){
		
	}
	
	/**
	 * Use this in your template (i.e super(name))
	 * @param name
	 */
	public JetTpl(String name) {
//		JetTpl.tplName = name;
		this.name = name;
	}
	
	/**
	 * Override this function to render the template the way you 
	 * want.
	 * @param vars
	 * @return
	 */
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
