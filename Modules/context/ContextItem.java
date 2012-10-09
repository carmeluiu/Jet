package Jet.Modules.context;

import Jet.JetController;
import Jet.Module;

public class ContextItem {

	private JetController controller;
	
	private String uniqueName;
	
	private String title;
	
	private Module module;
	
	public ContextItem(){
		
	}

	public JetController getController() {
		return controller;
	}

	public void setController(JetController controller) {
		this.controller = controller;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	
	
	
}
