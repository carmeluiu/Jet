package Jet.themes.defaultTheme.templates;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import Jet.JetTpl;
import Jet.TplVars;

public class PageTpl extends JetTpl {

	private JPanel parent;
	
	public static String NAME = "page" ;
	
//	private final String header = "header";
	public PageTpl(Component parent){
		super("page");
		this.parent = (JPanel) parent;
//		JetTpl.tplName = "page";
//		name = "page";
	}
	
	/**
	 * 
	 */
	@Override
	public Component render(TplVars vars) {
		if(vars.containsKey("header")){
			parent.add((Component) vars.get("header"), BorderLayout.NORTH);
		}
		if(vars.containsKey("content")){
			parent.add((Component) vars.get("content"), BorderLayout.CENTER);
		}
		else{
			vars.put("content", new DefaultContent());
			parent.add((Component) vars.get("content"), BorderLayout.CENTER);
		}
		if(vars.containsKey("leftSidebar")){
			parent.add((Component) vars.get("leftSidebar"), BorderLayout.WEST);
		}
//		return super.render(vars);
		return parent;
	}
	
	
	
	
}
