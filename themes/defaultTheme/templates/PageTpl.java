package Jet.themes.defaultTheme.templates;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import Jet.JetTpl;
import Jet.TplVars;

public class PageTpl extends JetTpl {

	private JPanel parent;
	
	private Component content;
	
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
			content = (Component) vars.get("content");
			parent.add(content, BorderLayout.CENTER);
		}
		else{
			vars.put("content", new DefaultContent());
			content = (Component) vars.get("content");
			parent.add(content, BorderLayout.CENTER);
		}
		if(vars.containsKey("leftSidebar")){
			parent.add((Component) vars.get("leftSidebar"), BorderLayout.WEST);
		}
//		return super.render(vars);
		return parent;
	}

	public Component getContent() {
		return content;
	}

	public void setContent(Component content) {
		this.content = content;
	}
	
	
	
	
}
