package Jet.Modules.context.templates;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;

import Jet.JetTpl;
import Jet.TplVars;
import Jet.Modules.context.ContextItem;

public class ContextLinkTpl extends JetTpl{
	
	public static String NAME = "contextLink";
	
//	private String title;
	private ContextItem item;
	
	
	public ContextLinkTpl(String name) {
		super(name);
	}

	@Override
	public Component render(TplVars vars) {
		Component result;
		if(vars.containsKey("item")) {
			result = (Component) vars.get("item");
		}
		else{
			JLabel link = new JLabel(item.getTitle());
			link.setForeground(Color.BLUE);
			result = link;
		}
		return result;
	}
	
	private Component getLink(){
		JLabel link = new JLabel(item.getTitle());
		link.setForeground(Color.BLUE);
		
		
		return link;
	}

	public ContextItem getItem() {
		return item;
	}

	public void setItem(ContextItem item) {
		this.item = item;
	}

	
	
	
	
}
