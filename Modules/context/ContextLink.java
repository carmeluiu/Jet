package Jet.Modules.context;

import java.awt.Component;

import Jet.Module;
import Jet.Modules.context.templates.ContextLinkTpl;

public class ContextLink {

	
	private ContextItem item;
	
	private Module module;
	
	private ContextLinkTpl linkTpl;
	
	public ContextLink(ContextItem item){
		this.item = item;
	}
	
	public ContextLink(ContextItem item, Module module){
		this(item);
		this.module = module;
	}
	
	public Component render() {
		linkTpl = new ContextLinkTpl(ContextLinkTpl.NAME);
		linkTpl.setItem(item);
		return Module.syst.render(linkTpl, module);
	}
}
