package Jet.themes.defaultTheme.templates;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import Jet.JetTpl;
import Jet.TplVars;

public class PageTpl extends JetTpl {

	private JPanel parent;
	
	public PageTpl(Component parent){
		this.parent = (JPanel) parent;
	}
	
	@Override
	public Component render(TplVars vars) {
		parent.add((Component) vars.get("header"), BorderLayout.NORTH);
		parent.add((Component) vars.get("content"), BorderLayout.CENTER);
		parent.add((Component) vars.get("leftSidebar"), BorderLayout.WEST);
		return super.render(vars);
	}
	
	
	
}
